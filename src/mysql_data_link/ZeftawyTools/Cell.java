/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysql_data_link.ZeftawyTools;

/**
 *
 * @author New
 */
public class  Cell{
String name ;
Object Value ;
String Dates[]= new String[2];
boolean isbetween;
 
boolean  selectAsSum;

    public boolean isSelectAsSum() {
        return selectAsSum;
    }

    public void setSelectAsSum(boolean selectAsSum) {
        this.selectAsSum = selectAsSum;
    }


    public boolean isIsbetween() {
        return isbetween;
    }


    public String[] getDates() {
        return Dates;
    }

    public void setDates(String[] Dates) {
        this.Dates = Dates;
    }
     
String WhereString; String Andor ;
boolean ShowInTable ;
String Caption ;
IControl control;

    public IControl getControl() {
        return control;
    }

    public void setControl(IControl control) {
        this.control = control;
    }

    public String getCaption() {
        return Caption;
    }

    public void setCaption(String Caption) {
        this.Caption = Caption;
    }

    public boolean isShowInTable() {
        return ShowInTable;
    }

    public void setShowInTable(boolean ShowInTable) {
        this.ShowInTable = ShowInTable;
    }
 public void setShowInTable(boolean ShowInTable, String Capt) {
        this.ShowInTable = ShowInTable;
Caption = Capt;   
 }

    public String getWhereString() {
        return WhereString;
    }

    public String getAndor() {
        return Andor;
    }

    public Cell(String name) {
        this.name = name;
    }
  public Cell(String name, boolean iskey) {
      this.setIsKey(iskey);
        this.name = name;
    }
    public Object getValue() {
        return Value;
    }

    public void setValue(Object Value) {
        this.Value = Value;
    }

    public String getName() {
        return name;
       
    }
       boolean  isKey = false;

    public boolean isIsKey() {
        return isKey;
    }

    public void setIsKey(boolean isKey) {
        this.isKey = isKey;
    }
public  setAndor setaAndors;

 
 public  void SetWhere(setwhere setwhere , setAndor setAndor1 , Object Val){
 switch(setAndor1){
     case And :
         Andor = "And";
         break;
     case or:
         Andor="Or";
         break;
 }
     switch (setwhere) {
         case Equl:
             WhereString=  name + " =?";
             break;
             case  Like :
             WhereString=  name + " Like ?";     
             break;
          case betweenNom:
              WhereString=  name + " <=? And "+ name + ">=?";
             break;
          case greater:
              WhereString=  name + " >?";
             break;
          case greaterequal:
              WhereString=  name + " <=?";
             break;
          case losser:
              WhereString=  name + " <?";
             break;
          case losserequal:
              WhereString=  name + " <=?";
             break;
         
             
         default:
              WhereString=  name + " =?";
             throw new AssertionError();
     }
     setValue(Val);
     isbetween = false;
 }
   String selectsum(){
 return "IF(ISNull(sum("+name+")),0,sum("+name+")) As "+ name;
 }
 
  public  void SetWhereDateBetween( setAndor setAndor1 , String Val1 , String Val2){
 switch(setAndor1){
     case And :
         Andor = "And";
         break;
     case or:
         Andor="Or";
         break;
 }
   
 
              WhereString=  name + " Between ? And ?";
        
              
    Dates[0] = Val1 ; 
    Dates[1] = Val2;
    isbetween = true ; 
     
 }
 
}
