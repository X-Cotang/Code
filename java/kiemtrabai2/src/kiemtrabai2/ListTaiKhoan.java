package kiemtrabai2;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author tutq9
 */
public class ListTaiKhoan {
    private ArrayList<TaiKhoan> list = new ArrayList<>();
    
    
    public void ThemTK(TaiKhoan tk)
    {
        list.add(tk);
    }
    
    public String DangNhap(String s)
    {
        String tmp[] = s.split("\\$");
        for(int i = 0;i<list.size();++i)
        {
            TaiKhoan tk = list.get(i);
            if(tk.getUsername().equals(tmp[0]) && tk.getPwd().equals(tmp[1]))
            {
                return tk.getSTK();
            }
        }
        return "";
    }
    
    public boolean ChuyenTien(String stk1,String stk2,int sotien)
    {
        if(sotien<0) 
            return false;
        for(int i = 0;i<list.size();++i)
        {
            TaiKhoan tk = list.get(i);
            if(tk.getSTK().equals(stk1))
            {
                if(tk.tru(sotien)==false)
                    return false;
                break;
            }
        }
        for(int i = 0;i<list.size();++i)
        {
            TaiKhoan tk = list.get(i);
            if(tk.getSTK().equals(stk2))
            {
                tk.them(sotien);
                break;
            }
        }
        return true;
    }
    
    
    public boolean ruttien(String stk,int sotien)
    {
        for(int i = 0;i<list.size();++i)
        {
            TaiKhoan tk = list.get(i);
            if(tk.getSTK().equals(stk))
            {
                return tk.tru(sotien);
            }
        }
        return false;
    }
    
    public int getSodu(String stk)
    {
        for(int i = 0;i<list.size();++i)
            if(list.get(i).getSTK().equals(stk))
                return list.get(i).getSodu();
        return 0;
    }
    
    public boolean checkSTK(String stk)
    {
        for(int i = 0;i<list.size();++i)
            if(list.get(i).getSTK().equals(stk))
                return true;
        return false;
    }
    
    public String getLSGD(String stk)
    {
        for(int i = 0;i<list.size();++i)
        {
            TaiKhoan tk = list.get(i);
            if(tk.getSTK().equals(stk))
            {
                return tk.getLSGD();
            }
        }
        return "";
    }
    
    public void update() throws FileNotFoundException, IOException
    {
        FileWriter fr = new FileWriter("db.dat");
        BufferedWriter br = new BufferedWriter(fr);
        String line;
        for(int i = 0;i<list.size();++i)
        {
            String s = list.get(i).toString();
            br.write(s+"\n");
        }
        br.close();
        fr.close();
    }
}
