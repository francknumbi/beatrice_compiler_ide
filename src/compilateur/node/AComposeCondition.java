/* This file was generated by SableCC (http://www.sablecc.org/). */

package compilateur.node;

import compilateur.analysis.*;

@SuppressWarnings("nls")
public final class AComposeCondition extends PCondition
{
    private PConditionCompose _conditionCompose_;

    public AComposeCondition()
    {
        // Constructor
    }

    public AComposeCondition(
        @SuppressWarnings("hiding") PConditionCompose _conditionCompose_)
    {
        // Constructor
        setConditionCompose(_conditionCompose_);

    }

    @Override
    public Object clone()
    {
        return new AComposeCondition(
            cloneNode(this._conditionCompose_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAComposeCondition(this);
    }

    public PConditionCompose getConditionCompose()
    {
        return this._conditionCompose_;
    }

    public void setConditionCompose(PConditionCompose node)
    {
        if(this._conditionCompose_ != null)
        {
            this._conditionCompose_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._conditionCompose_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._conditionCompose_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._conditionCompose_ == child)
        {
            this._conditionCompose_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._conditionCompose_ == oldChild)
        {
            setConditionCompose((PConditionCompose) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}