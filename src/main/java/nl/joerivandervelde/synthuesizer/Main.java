package nl.joerivandervelde.synthuesizer;

/**
 * Create a new Synthuesizer using the location of a properties file.
 */
public class Main {
    public static void main(String args[])
            throws Exception {
        if (args.length != 1) {
            System.out.println("You should supply 1 argument: location of a " +
                    "properties file. This properties file must contain " +
                    "at least two lines containing 'bridge_ip = XXX' and " +
                    "'api_key = XXX'. Your Hue bridge IP can be discovered " +
                    "using https://discovery.meethue.com/. To create an API " +
                    "key, see: https://developers.meethue" +
                    ".com/develop/get-started-2/.");
            new Synthuesizer();
        }else{
            new Synthuesizer(args[0]);
        }
    }
}
