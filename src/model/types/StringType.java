package model.types;

import model.values.IValue;
import model.values.StringValue;

public class StringType implements IType{
    @Override
    public boolean equals(Object another){
        return another instanceof StringType;

    }

    @Override
    public IValue defaultValue() {
        return new StringValue("null");

    }

    public String toString(){
        return "string";

    }

}
