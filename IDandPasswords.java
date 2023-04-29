import java.util.HashMap;

public class IDandPasswords {

    HashMap<String,String> logininfo = new HashMap<String,String>();

    IDandPasswords(){

        logininfo.put("Biki","123");
        logininfo.put("lpu","abcd");
        logininfo.put("cse","java");
    }

    public HashMap<String, String> getLoginInfo(){
        return logininfo;
    }
}