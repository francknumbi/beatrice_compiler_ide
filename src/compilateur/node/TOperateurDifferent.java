/* This file was generated by SableCC (http://www.sablecc.org/). */

package compilateur.node;

import compilateur.analysis.*;

@SuppressWarnings("nls")
public final class TOperateurDifferent extends Token
{
    public TOperateurDifferent()
    {
        super.setText("<>");
    }

    public TOperateurDifferent(int line, int pos)
    {
        super.setText("<>");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TOperateurDifferent(getLine(), getPos());
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTOperateurDifferent(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TOperateurDifferent text.");
    }
}