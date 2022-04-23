/* This file was generated by SableCC (http://www.sablecc.org/). */

package compilateur.node;

import compilateur.analysis.*;

@SuppressWarnings("nls")
public final class TDebut extends Token
{
    public TDebut()
    {
        super.setText("debut");
    }

    public TDebut(int line, int pos)
    {
        super.setText("debut");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TDebut(getLine(), getPos());
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTDebut(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TDebut text.");
    }
}
