import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class UnitConverter{

    private final Map<String, Double> conTable = new HashMap<>();

    public UnitConverter(){
        this.useLengthUnits();
    }

    public void useLengthUnits(){
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
    
    public String convert(String unit, double val, String rUnit){
        double c = convertToMeter(unit, val);

        DecimalFormat df = new DecimalFormat("#.###");
        return df.format(conTable.get(rUnit) * c);
    }

    private double convertToMeter(String u, double v){
        return 1 / (conTable.get(u) / v);
    }
}