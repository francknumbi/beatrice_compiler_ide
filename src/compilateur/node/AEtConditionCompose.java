/* This file was generated by SableCC (http://www.sablecc.org/). */

package compilateur.node;

import compilateur.analysis.*;

@SuppressWarnings("nls")
public final class AEtConditionCompose extends PConditionCompose
{
    private PConditionSimple _gauche_;
    private TOperateurEt _operateurEt_;
    private PConditionSimple _droite_;

    public AEtConditionCompose()
    {
        // Constructor
    }

    public AEtConditionCompose(
        @SuppressWarnings("hiding") PConditionSimple _gauche_,
        @SuppressWarnings("hiding") TOperateurEt _operateurEt_,
        @SuppressWarnings("hiding") PConditionSimple _droite_)
    {
        // Constructor
        setGauche(_gauche_);

        setOperateurEt(_operateurEt_);

        setDroite(_droite_);

    }

    @Override
    public Object clone()
    {
        return new AEtConditionCompose(
            cloneNode(this._gauche_),
            cloneNode(this._operateurEt_),
            cloneNode(this._droite_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAEtConditionCompose(this);
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

    public TOperateurEt getOperateurEt()
    {
        return this._operateurEt_;
    }

    public void setOperateurEt(TOperateurEt node)
    {
        if(this._operateurEt_ != null)
        {
            this._operateurEt_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._operateurEt_ = node;
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
            + toString(this._operateurEt_)
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

        if(this._operateurEt_ == child)
        {
            this._operateurEt_ = null;
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

        if(this._operateurEt_ == oldChild)
        {
            setOperateurEt((TOperateurEt) newChild);
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
