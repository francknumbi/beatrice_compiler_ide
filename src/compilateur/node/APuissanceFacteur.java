/* This file was generated by SableCC (http://www.sablecc.org/). */

package compilateur.node;

import compilateur.analysis.*;

@SuppressWarnings("nls")
public final class APuissanceFacteur extends PFacteur
{
    private PFacteur _facteur_;
    private TPuissance _puissance_;
    private PTerme _terme_;

    public APuissanceFacteur()
    {
        // Constructor
    }

    public APuissanceFacteur(
        @SuppressWarnings("hiding") PFacteur _facteur_,
        @SuppressWarnings("hiding") TPuissance _puissance_,
        @SuppressWarnings("hiding") PTerme _terme_)
    {
        // Constructor
        setFacteur(_facteur_);

        setPuissance(_puissance_);

        setTerme(_terme_);

    }

    @Override
    public Object clone()
    {
        return new APuissanceFacteur(
            cloneNode(this._facteur_),
            cloneNode(this._puissance_),
            cloneNode(this._terme_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAPuissanceFacteur(this);
    }

    public PFacteur getFacteur()
    {
        return this._facteur_;
    }

    public void setFacteur(PFacteur node)
    {
        if(this._facteur_ != null)
        {
            this._facteur_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._facteur_ = node;
    }

    public TPuissance getPuissance()
    {
        return this._puissance_;
    }

    public void setPuissance(TPuissance node)
    {
        if(this._puissance_ != null)
        {
            this._puissance_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._puissance_ = node;
    }

    public PTerme getTerme()
    {
        return this._terme_;
    }

    public void setTerme(PTerme node)
    {
        if(this._terme_ != null)
        {
            this._terme_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._terme_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._facteur_)
            + toString(this._puissance_)
            + toString(this._terme_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._facteur_ == child)
        {
            this._facteur_ = null;
            return;
        }

        if(this._puissance_ == child)
        {
            this._puissance_ = null;
            return;
        }

        if(this._terme_ == child)
        {
            this._terme_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._facteur_ == oldChild)
        {
            setFacteur((PFacteur) newChild);
            return;
        }

        if(this._puissance_ == oldChild)
        {
            setPuissance((TPuissance) newChild);
            return;
        }

        if(this._terme_ == oldChild)
        {
            setTerme((PTerme) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
