package id.co.veritrans.mdk.v1.gateway.model.vtweb;

import com.fasterxml.jackson.annotation.JsonProperty;
import id.co.veritrans.mdk.v1.gateway.model.AbstractVtRequest;
import id.co.veritrans.mdk.v1.gateway.model.CustomerDetails;
import id.co.veritrans.mdk.v1.gateway.model.TransactionDetails;
import id.co.veritrans.mdk.v1.gateway.model.TransactionItem;

import java.util.List;

/**
 * VtWeb charge request parameter used to make a VtWeb charge request.
 * Created by gde on 5/20/15.
 */
public class VtWebChargeRequest extends AbstractVtRequest {

    /**
     * Internal usage.
     */
    @JsonProperty
    private final String paymentType = "vtweb";
    /**
     * The {@link id.co.veritrans.mdk.v1.gateway.model.vtweb.VtWebParam} describing the configuration for the charge
     * request.
     */
    private VtWebParam vtWeb;

    /**
     * VtWebChargeRequest default constructor.
     */
    public VtWebChargeRequest() {
    }

    /**
     * VtWebChargeRequest constructor.
     *
     * @param transactionDetails {@link id.co.veritrans.mdk.v1.gateway.model.TransactionDetails Transaction details}.
     * @param vtWeb              VtWeb parameter.
     */
    public VtWebChargeRequest(final TransactionDetails transactionDetails, final VtWebParam vtWeb) {
        super(transactionDetails);
        this.vtWeb = vtWeb;
    }

    /**
     * VtWebChargeRequest constructor.
     *
     * @param transactionDetails {@link id.co.veritrans.mdk.v1.gateway.model.TransactionDetails Transaction details}.
     * @param itemDetails        List of {@link id.co.veritrans.mdk.v1.gateway.model.TransactionItem transaction item}.
     * @param customerDetails    Transaction {@link id.co.veritrans.mdk.v1.gateway.model.CustomerDetails customer details}.
     * @param vtWeb              VtWeb parameter.
     */
    public VtWebChargeRequest(final TransactionDetails transactionDetails, final List<TransactionItem> itemDetails, final CustomerDetails customerDetails, final VtWebParam vtWeb) {
        super(transactionDetails, itemDetails, customerDetails);
        this.vtWeb = vtWeb;
    }

    public VtWebParam getVtWeb() {
        return vtWeb;
    }

    public void setVtWeb(final VtWebParam vtWeb) {
        this.vtWeb = vtWeb;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        final VtWebChargeRequest that = (VtWebChargeRequest) o;

        if (paymentType != null ? !paymentType.equals(that.paymentType) : that.paymentType != null) return false;
        if (vtWeb != null ? !vtWeb.equals(that.vtWeb) : that.vtWeb != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (paymentType != null ? paymentType.hashCode() : 0);
        result = 31 * result + (vtWeb != null ? vtWeb.hashCode() : 0);
        return result;
    }
}
