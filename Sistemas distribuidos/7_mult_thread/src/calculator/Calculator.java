package calculator;

public final class Calculator {
  public static Calculator instancia;

  private Calculator(){

  }

  public static synchronized Calculator getInstance(){
    if (instancia == null){
      instancia = new Calculator();
    }
    return instancia;
  }

  public double add(double op1, double op2){
    return op1+op2;
  }
  public double sub(double op1, double op2){
    return op1-op2;
  }
  public double mult(double op1, double op2){
    return op1*op2;
  }
  public double div(double op1, double op2){
    if(op2==0){
      throw new IllegalArgumentException("Não é possível dividir por zero.");
    }
    return op1/op2;
  }
}
