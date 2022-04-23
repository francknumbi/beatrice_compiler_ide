/* This file was generated by SableCC (http://www.sablecc.org/). */

package compilateur.node;

import compilateur.analysis.*;

@SuppressWarnings("nls")
public final class ADefAdd extends PDefAdd
{
    private PPrefixeCompose _prefixeCompose_;
    private PSuffixe _suffixe_;

    public ADefAdd()
    {
        // Constructor
    }

    public ADefAdd(
        @SuppressWarnings("hiding") PPrefixeCompose _prefixeCompose_,
        @SuppressWarnings("hiding") PSuffixe _suffixe_)
    {
        // Constructor
        setPrefixeCompose(_prefixeCompose_);

        setSuffixe(_suffixe_);

    }

    @Override
    public Object clone()
    {
        return new ADefAdd(
            cloneNode(this._prefixeCompose_),
            cloneNode(this._suffixe_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseADefAdd(this);
    }

    public PPrefixeCompose getPrefixeCompose()
    {
        return this._prefixeCompose_;
    }

    public void setPrefixeCompose(PPrefixeCompose node)
    {
        if(this._prefixeCompose_ != null)
        {
            this._prefixeCompose_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._prefixeCompose_ = node;
    }

    public PSuffixe getSuffixe()
    {
        return this._suffixe_;
    }

    public void setSuffixe(PSuffixe node)
    {
        if(this._suffixe_ != null)
        {
            this._suffixe_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._suffixe_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._prefixeCompose_)
            + toString(this._suffixe_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._prefixeCompose_ == child)
        {
            this._prefixeCompose_ = null;
            return;
        }

        if(this._suffixe_ == child)
        {
            this._suffixe_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._prefixeCompose_ == oldChild)
        {
            setPrefixeCompose((PPrefixeCompose) newChild);
            return;
        }

        if(this._suffixe_ == oldChild)
        {
            setSuffixe((PSuffixe) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
