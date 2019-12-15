package nl.joerivandervelde.synthuesizer.sound;

import javax.sound.midi.*;
import java.util.HashMap;

/**
 * The Sound class sets up the MIDI environment, facilitates changing
 * instrument and pitch, and handles sound events upon pressing and releasing
 * notes. This implementation is multitimbral, ie. the played notes are
 * distributed across 8 channels to potentially allow more simultaneous notes.
 * However, this does require a keyboard with n-key rollover.
 */
public class Sound {

    // limit to using channels
    private static final int MAX_CHANNEL = 8;

    private Synthesizer syn;
    private MidiChannel[] midChannel;
    private Instrument[] instruments;
    private int currentInstrument;
    private int nrOfNotes;
    private int pitch;
    private int nextChannel;
    private HashMap<Integer, Integer> activeNotes = new HashMap<Integer,
            Integer>();

    /**
     * Constructor
     *
     * @param defaultIns
     * @param defaultPitch
     * @param nrOfNotes
     * @throws MidiUnavailableException
     */
    public Sound(int defaultIns, int defaultPitch, int nrOfNotes)
            throws MidiUnavailableException {
        this.nextChannel = 0;
        this.pitch = defaultPitch;
        this.nrOfNotes = nrOfNotes;
        syn = MidiSystem.getSynthesizer();
        syn.open();
        midChannel = syn.getChannels();
        instruments = syn.getDefaultSoundbank().getInstruments();
        changeInstrumentTo(defaultIns);
    }

    /**
     * Set selected instrument to this particular index (0-127).
     *
     * @param instrument
     */
    public void changeInstrumentTo(int instrument) {
        System.out.println("Setting instrument to nr. " + instrument + ", " +
                instruments[instrument].getName());
        syn.loadInstrument(instruments[instrument]);
        for (int i = 0; i < MAX_CHANNEL; i++) {
            midChannel[i].programChange(
                    instruments[instrument].getPatch().getProgram());
        }
        currentInstrument = instrument;
    }


    /**
     * Increase or decrease the current instrument index with int delta.
     *
     * @param delta
     */
    public void changeInstrument(int delta) {
        int changeTo = (currentInstrument + delta) % 128;
        changeTo = changeTo < 0 ? 127 : changeTo;
        changeInstrumentTo(changeTo);
    }

    /**
     * Press a particular note with a particular velocity.
     *
     * @param noteNumber
     * @param velocity
     */
    public void pressNote(int noteNumber, int velocity) {
        int onChannel = nextChannel++;
        onChannel = onChannel % MAX_CHANNEL;
        this.midChannel[onChannel].noteOn(pitch + noteNumber, velocity);
        activeNotes.put(pitch + noteNumber, onChannel);
    }

    /**
     * Release a particular note. If pitch was changed while holding a note,
     * it was already released and will no longer be available for release
     * and is ignored.
     *
     * @param noteNumber
     */
    public void releaseNote(int noteNumber) {
        if (activeNotes.containsKey(pitch + noteNumber)) {
            int onChannel = activeNotes.get(pitch + noteNumber);
            this.midChannel[onChannel].noteOn(pitch + noteNumber, 0);
            activeNotes.remove(pitch + noteNumber);
        }
    }

    /**
     * Release all notes currently played.
     */
    public void releaseAllNotes() {
        for (int note : activeNotes.keySet()) {
            int onChannel = activeNotes.get(note);
            this.midChannel[onChannel].noteOn(note, 0);
            activeNotes.remove(note);
        }
    }

    /**
     * Increase or decrease the current pitch with int delta. This value is
     * limited to the range 0 - (128-nrOfNotes) to cover but not exceed the
     * full range of note pitches.
     *
     * @param delta
     */
    public void changePitch(int delta) {
        releaseAllNotes();
        pitch = pitch + delta;
        pitch = pitch < 0 ? 0 : pitch;
        pitch = pitch > 128 - nrOfNotes ? 128 - nrOfNotes : pitch;
        System.out.println("Setting pitch to " + pitch);
    }
}
