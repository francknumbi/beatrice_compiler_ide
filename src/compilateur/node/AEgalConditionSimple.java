/* This file was generated by SableCC (http://www.sablecc.org/). */

package compilateur.node;

import compilateur.analysis.*;

@SuppressWarnings("nls")
public final class AEgalConditionSimple extends PConditionSimple
{
    private PExpress _gauche_;
    private TOperateurEgal _operateurEgal_;
    private PExpress _droite_;

    public AEgalConditionSimple()
    {
        // Constructor
    }

    public AEgalConditionSimple(
        @SuppressWarnings("hiding") PExpress _gauche_,
        @SuppressWarnings("hiding") TOperateurEgal _operateurEgal_,
        @SuppressWarnings("hiding") PExpress _droite_)
    {
        // Constructor
        setGauche(_gauche_);

        setOperateurEgal(_operateurEgal_);

        setDroite(_droite_);

    }

    @Override
    public Object clone()
    {
        return new AEgalConditionSimple(
            cloneNode(this._gauche_),
            cloneNode(this._operateurEgal_),
            cloneNode(this._droite_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAEgalConditionSimple(this);
    }

    public PExpress getGauche()
    {
        return this._gauche_;
    }

    public void setGauche(PExpress node)
    {
        if(this._gauche_ != null)
        {
            this._gauche_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._gauche_ = node;
    }

    public TOperateurEgal getOperateurEgal()
    {
        return this._operateurEgal_;
    }

    public void setOperateurEgal(TOperateurEgal node)
    {
        if(this._operateurEgal_ != null)
        {
            this._operateurEgal_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._operateurEgal_ = node;
    }

    public PExpress getDroite()
    {
        return this._droite_;
    }

    public void setDroite(PExpress node)
    {
        if(this._droite_ != null)
        {
            this._droite_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._droite_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._gauche_)
            + toString(this._operateurEgal_)
            + toString(this._droite_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._gauche_ == child)
        {
            this._gauche_ = null;
            return;
        }

        if(this._operateurEgal_ == child)
        {
            this._operateurEgal_ = null;
            return;
        }

        if(this._droite_ == child)
        {
            this._droite_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._gauche_ == oldChild)
        {
            setGauche((PExpress) newChild);
            return;
        }

        if(this._operateurEgal_ == oldChild)
        {
            setOperateurEgal((TOperateurEgal) newChild);
            return;
        }

        if(this._droite_ == oldChild)
        {
            setDroite((PExpress) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
