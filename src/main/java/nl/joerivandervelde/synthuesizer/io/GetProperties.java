package nl.joerivandervelde.synthuesizer.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Properties;

/**
 * Helper class to load and parse properties files.
 */
public class GetProperties {

    // static variables
    public static final String BRIDGE_IP = "bridge_ip";
    public static final String API_KEY = "api_key";

    // local variables
    private String propsFileLoc;
    private Properties props;

    /**
     * Constructor
     * @param propsFileLoc
     */
    public GetProperties(String propsFileLoc) {
        this.propsFileLoc = propsFileLoc;
        props = new Properties();
    }

    /**
     * Load the properties from the file location.
     * @return
     * @throws Exception
     */
    public Properties getProperties() throws Exception {
        File propsFile = new File(propsFileLoc);
        if (!propsFile.exists()) {
            throw new Exception("Could not find properties file at " +
                    propsFile.getAbsolutePath() +
                    ". Are you sure this is the correct location?");
        }

        if (propsFile.isDirectory()) {
            throw new Exception("The properties file location " +
                    propsFile.getAbsolutePath() +
                    " seems to be a directory. Are you sure this is the " +
                    "correct location?");

        }

        InputStream inputStream = new FileInputStream(propsFile);
        props.load(inputStream);

        for (String prop : Arrays.asList(new String[]{BRIDGE_IP, API_KEY})) {
            if (!props.containsKey(prop)) {
                throw new Exception("Property '" + prop + "' not found in " +
                        "properties file. Add it as '" + prop + " = xxx'.");
            }
            if (props.getProperty(prop).length() == 0) {
                throw new Exception("Property '" + prop + "' was found but " +
                        "had no value. Add it as '" + prop + " = xxx'.");
            }
        }
        inputStream.close();
        return props;
    }
}
