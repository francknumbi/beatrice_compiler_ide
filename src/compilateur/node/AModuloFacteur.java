/* This file was generated by SableCC (http://www.sablecc.org/). */

package compilateur.node;

import compilateur.analysis.*;

@SuppressWarnings("nls")
public final class AModuloFacteur extends PFacteur
{
    private PFacteur _facteur_;
    private TOperateurModulo _operateurModulo_;
    private PTerme _terme_;

    public AModuloFacteur()
    {
        // Constructor
    }

    public AModuloFacteur(
        @SuppressWarnings("hiding") PFacteur _facteur_,
        @SuppressWarnings("hiding") TOperateurModulo _operateurModulo_,
        @SuppressWarnings("hiding") PTerme _terme_)
    {
        // Constructor
        setFacteur(_facteur_);

        setOperateurModulo(_operateurModulo_);

        setTerme(_terme_);

    }

    @Override
    public Object clone()
    {
        return new AModuloFacteur(
            cloneNode(this._facteur_),
            cloneNode(this._operateurModulo_),
            cloneNode(this._terme_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAModuloFacteur(this);
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

    public TOperateurModulo getOperateurModulo()
    {
        return this._operateurModulo_;
    }

    public void setOperateurModulo(TOperateurModulo node)
    {
        if(this._operateurModulo_ != null)
        {
            this._operateurModulo_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._operateurModulo_ = node;
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
            + toString(this._operateurModulo_)
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

        if(this._operateurModulo_ == child)
        {
            this._operateurModulo_ = null;
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

        if(this._operateurModulo_ == oldChild)
        {
            setOperateurModulo((TOperateurModulo) newChild);
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
