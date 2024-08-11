package com.Medical.HealthCard.Uitls;

public class ExceptionXHandlers extends  RuntimeException{

      public ExceptionXHandlers(){
            super("Bad Request is recieved");
     }
     public ExceptionXHandlers(String msg){
          super(msg);
     }




}
