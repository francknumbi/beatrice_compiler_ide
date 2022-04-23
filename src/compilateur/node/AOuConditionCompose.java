/* This file was generated by SableCC (http://www.sablecc.org/). */

package compilateur.node;

import compilateur.analysis.*;

@SuppressWarnings("nls")
public final class AOuConditionCompose extends PConditionCompose
{
    private PConditionSimple _gauche_;
    private TOperateurOu _operateurOu_;
    private PConditionSimple _droite_;

    public AOuConditionCompose()
    {
        // Constructor
    }

    public AOuConditionCompose(
        @SuppressWarnings("hiding") PConditionSimple _gauche_,
        @SuppressWarnings("hiding") TOperateurOu _operateurOu_,
        @SuppressWarnings("hiding") PConditionSimple _droite_)
    {
        // Constructor
        setGauche(_gauche_);

        setOperateurOu(_operateurOu_);

        setDroite(_droite_);

    }

    @Override
    public Object clone()
    {
        return new AOuConditionCompose(
            cloneNode(this._gauche_),
            cloneNode(this._operateurOu_),
            cloneNode(this._droite_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAOuConditionCompose(this);
    }

    public PConditionSimple getGauche()
    {
        return this._gauche_;
    }

    public void setGauche(PConditionSimple node)
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

    public TOperateurOu getOperateurOu()
    {
        return this._operateurOu_;
    }

    public void setOperateurOu(TOperateurOu node)
    {
        if(this._operateurOu_ != null)
        {
            this._operateurOu_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._operateurOu_ = node;
    }

    public PConditionSimple getDroite()
    {
        return this._droite_;
    }

    public void setDroite(PConditionSimple node)
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
            + toString(this._operateurOu_)
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

        if(this._operateurOu_ == child)
        {
            this._operateurOu_ = null;
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
            setGauche((PConditionSimple) newChild);
            return;
        }

        if(this._operateurOu_ == oldChild)
        {
            setOperateurOu((TOperateurOu) newChild);
            return;
        }

        if(this._droite_ == oldChild)
        {
            setDroite((PConditionSimple) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}