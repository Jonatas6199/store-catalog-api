package VO;

public class StandardVO {
    private int standardId = 0;

    public void setId(int id) throws Exception {
        if(id > 0)
            standardId = id;
        else
            throw new Exception("Id deve ser maior que 0");
    }
    public int getId(){
        return standardId;
    }
}
