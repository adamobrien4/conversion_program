import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

public class UnitConverter{

    private final Map<String, Double> conTable = new HashMap<>();
    public ArrayList<String> units = new ArrayList<>();
    private ArrayList<Double> unitValues = new ArrayList<>();

    public void useLengthUnits(){
        units.clear();
        units.addAll(Arrays.asList(
            "Meter",
            "Kilometer",
            "Centimeter",
            "Milimeter",
            "Inch",
            "Foot",
            "Mile",
            "Yard"
        ));

        unitValues.clear();
        unitValues.addAll(Arrays.asList(
            1.0,
            .001,
            100.0,
            1000.0,
            39.3701,
            3.280842,
            0.00062137,
            1.09361
        ));

        updateConversionTable();
    }

    public void useVolumeUnits(){
        units.clear();
        units.addAll(Arrays.asList(
            "Litre",
            "Mililitre",
            "Gallon",
            "Pint",
            "Fluid Ounce",
            "Tablespoon",
            "Teaspoon"
        ));

        unitValues.clear();
        unitValues.addAll(Arrays.asList(
            1.0,
            .001,
            0.219969,
            1.75975,
            35.1951,
            56.3121,
            168.936
        ));

        updateConversionTable();
    }

    public void useAreaUnits(){
        units.clear();
        units.addAll(Arrays.asList(
            "Square Meter",
            "Square Kilometer",
            "Square Mile",
            "Square Yard",
            "Square Foot",
            "Square Inch",
            "Hectare",
            "Acre"
        ));

        unitValues.clear();
        unitValues.addAll(Arrays.asList(
            1.0,
            .001,
            .0000003861,
            1.19599,
            10.7639,
            1550.0,
            .0001,
            0.000247105
        ));

        updateConversionTable();
    }

    public void useSpeedUnits(){
        units.clear();
        units.addAll(Arrays.asList(
            "Meters per second",
            "Miles per hour",
            "Kilometers per hour",
            "Knots"
        ));

        unitValues.clear();
        unitValues.addAll(Arrays.asList(
            1.0,
            2.23694,
            3.6,
            1.94384
        ));

        updateConversionTable();
    }

    public void useTemperatureUnits(){
        units.clear();
        units.addAll(Arrays.asList(
            "Celcius",
            "Fahrenheit",
            "Kelvin"
        ));

        unitValues.clear();
        unitValues.addAll(Arrays.asList(
            1.0,
            1.8,
            274.15
        ));

        updateConversionTable();
    }

    private void updateConversionTable(){

        conTable.clear();
        for(int i = 0; i < units.size(); i++){
            conTable.put(units.get(i), unitValues.get(i));
        }

    }
    
    public String convert(String unit, double val, String rUnit){
        double c = convertToMeter(unit, val);

        DecimalFormat df = new DecimalFormat("#.###");
        return df.format(conTable.get(rUnit) * c);
    }

    private double convertToMeter(String u, double v){
        return 1 / (conTable.get(u) / v);
    }

    public UnitConverter(){
        this.useLengthUnits();
    }
}