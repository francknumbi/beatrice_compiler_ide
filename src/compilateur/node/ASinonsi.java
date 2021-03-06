/* This file was generated by SableCC (http://www.sablecc.org/). */

package compilateur.node;

import java.util.*;
import compilateur.analysis.*;

@SuppressWarnings("nls")
public final class ASinonsi extends PSinonsi
{
    private TSinonsi _sinonsi_;
    private PCondition _condition_;
    private TAlors _alors_;
    private final LinkedList<PInstructions> _instructions_ = new LinkedList<PInstructions>();

    public ASinonsi()
    {
        // Constructor
    }

    public ASinonsi(
        @SuppressWarnings("hiding") TSinonsi _sinonsi_,
        @SuppressWarnings("hiding") PCondition _condition_,
        @SuppressWarnings("hiding") TAlors _alors_,
        @SuppressWarnings("hiding") List<?> _instructions_)
    {
        // Constructor
        setSinonsi(_sinonsi_);

        setCondition(_condition_);

        setAlors(_alors_);

        setInstructions(_instructions_);

    }

    @Override
    public Object clone()
    {
        return new ASinonsi(
            cloneNode(this._sinonsi_),
            cloneNode(this._condition_),
            cloneNode(this._alors_),
            cloneList(this._instructions_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseASinonsi(this);
    }

    public TSinonsi getSinonsi()
    {
        return this._sinonsi_;
    }

    public void setSinonsi(TSinonsi node)
    {
        if(this._sinonsi_ != null)
        {
            this._sinonsi_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._sinonsi_ = node;
    }

    public PCondition getCondition()
    {
        return this._condition_;
    }

    public void setCondition(PCondition node)
    {
        if(this._condition_ != null)
        {
            this._condition_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._condition_ = node;
    }

    public TAlors getAlors()
    {
        return this._alors_;
    }

    public void setAlors(TAlors node)
    {
        if(this._alors_ != null)
        {
            this._alors_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._alors_ = node;
    }

    public LinkedList<PInstructions> getInstructions()
    {
        return this._instructions_;
    }

    public void setInstructions(List<?> list)
    {
        for(PInstructions e : this._instructions_)
        {
            e.parent(null);
        }
        this._instructions_.clear();

        for(Object obj_e : list)
        {
            PInstructions e = (PInstructions) obj_e;
            if(e.parent() != null)
            {
                e.parent().removeChild(e);
            }

            e.parent(this);
            this._instructions_.add(e);
        }
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._sinonsi_)
            + toString(this._condition_)
            + toString(this._alors_)
            + toString(this._instructions_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._sinonsi_ == child)
        {
            this._sinonsi_ = null;
            return;
        }

        if(this._condition_ == child)
        {
            this._condition_ = null;
            return;
        }

        if(this._alors_ == child)
        {
            this._alors_ = null;
            return;
        }

        if(this._instructions_.remove(child))
        {
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._sinonsi_ == oldChild)
        {
            setSinonsi((TSinonsi) newChild);
            return;
        }

        if(this._condition_ == oldChild)
        {
            setCondition((PCondition) newChild);
            return;
        }

        if(this._alors_ == oldChild)
        {
            setAlors((TAlors) newChild);
            return;
        }

        for(ListIterator<PInstructions> i = this._instructions_.listIterator(); i.hasNext();)
        {
            if(i.next() == oldChild)
            {
                if(newChild != null)
                {
                    i.set((PInstructions) newChild);
                    newChild.parent(this);
                    oldChild.parent(null);
                    return;
                }

                i.remove();
                oldChild.parent(null);
                return;
            }
        }

        throw new RuntimeException("Not a child.");
    }
}
