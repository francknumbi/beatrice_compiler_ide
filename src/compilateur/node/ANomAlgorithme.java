/* This file was generated by SableCC (http://www.sablecc.org/). */

package compilateur.node;

import compilateur.analysis.*;

@SuppressWarnings("nls")
public final class ANomAlgorithme extends PNomAlgorithme
{
    private TAlgorithme _algorithme_;
    private TIdentifiant _identifiant_;

    public ANomAlgorithme()
    {
        // Constructor
    }

    public ANomAlgorithme(
        @SuppressWarnings("hiding") TAlgorithme _algorithme_,
        @SuppressWarnings("hiding") TIdentifiant _identifiant_)
    {
        // Constructor
        setAlgorithme(_algorithme_);

        setIdentifiant(_identifiant_);

    }

    @Override
    public Object clone()
    {
        return new ANomAlgorithme(
            cloneNode(this._algorithme_),
            cloneNode(this._identifiant_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseANomAlgorithme(this);
    }

    public TAlgorithme getAlgorithme()
    {
        return this._algorithme_;
    }

    public void setAlgorithme(TAlgorithme node)
    {
        if(this._algorithme_ != null)
        {
            this._algorithme_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._algorithme_ = node;
    }

    public TIdentifiant getIdentifiant()
    {
        return this._identifiant_;
    }

    public void setIdentifiant(TIdentifiant node)
    {
        if(this._identifiant_ != null)
        {
            this._identifiant_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._identifiant_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._algorithme_)
            + toString(this._identifiant_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._algorithme_ == child)
        {
            this._algorithme_ = null;
            return;
        }

        if(this._identifiant_ == child)
        {
            this._identifiant_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._algorithme_ == oldChild)
        {
            setAlgorithme((TAlgorithme) newChild);
            return;
        }

        if(this._identifiant_ == oldChild)
        {
            setIdentifiant((TIdentifiant) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
