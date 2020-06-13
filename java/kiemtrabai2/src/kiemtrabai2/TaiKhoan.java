package kiemtrabai2;


public class TaiKhoan {
    private String username, pwd, Hoten, STK, LSGD;
    int sodu;
    
    
    public String getSTK()
    {
        return STK;
    }

    public String getUsername() {
        return username;
    }

    public String getPwd() {
        return pwd;
    }

    public String getHoten() {
        return Hoten;
    }

    public String getLSGD() {
        
        String tmp[] = LSGD.split("\\|");
        String dat = "";
        for (int i =0;i<tmp.length;++i)
        {
            dat += tmp[i];
            dat += "\n";
        }
        return dat;
        
    }

    public int getSodu() {
        return sodu;
    }
    
    public void them(int x)
    {
        sodu += x;
        LSGD += "|+";
        LSGD += String.valueOf(x);
                
    }
    
    public boolean tru(int x)
    {
        if(sodu-x<0) return false;
        sodu-=x;
        LSGD += "|-";
        LSGD += String.valueOf(x);
        return true;
    }
    
    

    public TaiKhoan(String username, String pwd, String Hoten, String STK, int sodu,String LSGD) {
        this.username = username;
        this.pwd = pwd;
        this.Hoten = Hoten;
        this.STK = STK;
        this.LSGD = LSGD;
        this.sodu = sodu;
    }
    
    @Override
    public String toString()
    {
        String s = "";
        s+=username+"$"+pwd+"$"+Hoten+"$"+STK + "$" + String.valueOf(sodu)+"$"+LSGD;
        return s;
    }
    
}
