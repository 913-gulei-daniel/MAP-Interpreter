package model.expressions;

import model.collections.dictionary.IDictionary;
import model.collections.heap.IHeap;
import model.values.IValue;

@SuppressWarnings("unused")
public class ValueExpression implements IExpression{
    IValue e;

    public ValueExpression(IValue val){
        e = val;

    }

    @Override
    public String toString() {
        return e.toString();
    }

    @Override
    public IValue evaluate(IDictionary<String, IValue> tbl, IHeap heap) {
        return e;

    }

}
