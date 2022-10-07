package week_1;

public class TimeConversion {
    public static void main(String[] args) {
        System.out.println(timeConversion("12:05:45PM"));
    }

    public static String timeConversion(String s) {
        int hour = Integer.parseInt(s.substring(0,2));
        String ampm = s.substring(8);
        if(ampm.equals("AM")){
            hour %= 12;
        }else{
            hour = (hour%12)+12;
        }
        
        String time = "";
        if(hour/10==0){
            time += "0"+hour+s.substring(2,8);
        }else{
            time += hour+s.substring(2,8);
        }
        return time;
    }
}
