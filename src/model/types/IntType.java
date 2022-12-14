package model.types;

import model.values.IValue;
import model.values.IntValue;

public class IntType implements IType{
    @Override
    public boolean equals(Object another){
        return another instanceof IntType;

    }

    @Override
    public IValue defaultValue() {
        return new IntValue(0);

    }

    public String toString(){
        return "int";

    }

}
