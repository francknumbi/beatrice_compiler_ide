/* This file was generated by SableCC (http://www.sablecc.org/). */

package compilateur.node;

import compilateur.analysis.*;

@SuppressWarnings("nls")
public final class AAffectation extends PAffectation
{
    private TIdentifiant _identifiant_;
    private TOperateurAffectation _operateurAffectation_;
    private PExpress _express_;

    public AAffectation()
    {
        // Constructor
    }

    public AAffectation(
        @SuppressWarnings("hiding") TIdentifiant _identifiant_,
        @SuppressWarnings("hiding") TOperateurAffectation _operateurAffectation_,
        @SuppressWarnings("hiding") PExpress _express_)
    {
        // Constructor
        setIdentifiant(_identifiant_);

        setOperateurAffectation(_operateurAffectation_);

        setExpress(_express_);

    }

    @Override
    public Object clone()
    {
        return new AAffectation(
            cloneNode(this._identifiant_),
            cloneNode(this._operateurAffectation_),
            cloneNode(this._express_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAAffectation(this);
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

    public TOperateurAffectation getOperateurAffectation()
    {
        return this._operateurAffectation_;
    }

    public void setOperateurAffectation(TOperateurAffectation node)
    {
        if(this._operateurAffectation_ != null)
        {
            this._operateurAffectation_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._operateurAffectation_ = node;
    }

    public PExpress getExpress()
    {
        return this._express_;
    }

    public void setExpress(PExpress node)
    {
        if(this._express_ != null)
        {
            this._express_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._express_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._identifiant_)
            + toString(this._operateurAffectation_)
            + toString(this._express_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._identifiant_ == child)
        {
            this._identifiant_ = null;
            return;
        }

        if(this._operateurAffectation_ == child)
        {
            this._operateurAffectation_ = null;
            return;
        }

        if(this._express_ == child)
        {
            this._express_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._identifiant_ == oldChild)
        {
            setIdentifiant((TIdentifiant) newChild);
            return;
        }

        if(this._operateurAffectation_ == oldChild)
        {
            setOperateurAffectation((TOperateurAffectation) newChild);
            return;
        }

        if(this._express_ == oldChild)
        {
            setExpress((PExpress) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}