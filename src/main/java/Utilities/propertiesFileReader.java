package Utilities;

import java.io.FileReader;
import java.util.Properties;

public class propertiesFileReader {

    public String readPropertiesData(String propertyName){
        Properties p=new Properties();
        try
        {
            p.load(new FileReader("D://Selenium_BDD_WheelsEMI_Project//Wheels_EMI//Resources//Data.properties"));
        }
        catch (Exception e)
        {

        }
        return p.getProperty(propertyName);
    }

}
