import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

public class UnitConverter{

    private final Map<String, Double> conTable = new HashMap<>();
    public ArrayList<String> units = new ArrayList<>();

    public void useLengthUnits(){
        units.clear();
        units.addAll(Arrays.asList("m", "km", "cm", "mm", "in", "ft", "mile", "yd", "nmile"));

        conTable.clear();
        conTable.put("m", 1.0);
        conTable.put("km", .001);
        conTable.put("cm", 100.0);
        conTable.put("mm", 1000.0);
        conTable.put("in", 39.3701);
        conTable.put("ft", 3.280842);
        conTable.put("mile", 0.00062137);
        conTable.put("yd", 1.09361);
        conTable.put("nmile", 0.000539957);
    }

    public void useVolumeUnits(){
        units.clear();
        units.addAll(Arrays.asList("l", "ml"));

        conTable.clear();
        conTable.put("l", 1.0);
        conTable.put("ml", 1000.0);
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