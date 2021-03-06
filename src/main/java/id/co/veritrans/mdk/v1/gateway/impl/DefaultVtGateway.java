package id.co.veritrans.mdk.v1.gateway.impl;

import id.co.veritrans.mdk.v1.exception.RestClientException;
import id.co.veritrans.mdk.v1.gateway.VtGateway;
import id.co.veritrans.mdk.v1.gateway.VtGatewaySession;
import id.co.veritrans.mdk.v1.gateway.model.VtResponse;
import id.co.veritrans.mdk.v1.helper.StringConstant;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by gde on 5/4/15.
 */
public abstract class DefaultVtGateway implements VtGateway {

    private final VtGatewaySession vtGatewaySession;

    public DefaultVtGateway(final VtGatewaySession vtGatewaySession) {
        this.vtGatewaySession = vtGatewaySession;
    }

    public VtGatewaySession getVtGatewaySession() {
        return vtGatewaySession;
    }

    @Override
    public VtResponse approve(final String orderId) throws RestClientException, UnsupportedEncodingException {
        final String safeOrderId = URLEncoder.encode(orderId, "UTF-8");
        final String url = safeOrderId + "/" + StringConstant.APPROVE;

        return getVtGatewaySession().getRestClient().post(url);
    }

    @Override
    public VtResponse status(final String orderId) throws RestClientException, UnsupportedEncodingException {
        final String safeOrderId = URLEncoder.encode(orderId, "UTF-8");
        final String url = safeOrderId + "/" + StringConstant.GET_STATUS;

        return getVtGatewaySession().getRestClient().get(url);
    }

    @Override
    public VtResponse cancel(final String orderId) throws RestClientException, UnsupportedEncodingException {
        final String safeOrderId = URLEncoder.encode(orderId, "UTF-8");
        final String url = safeOrderId + "/" + StringConstant.CANCEL;

        return getVtGatewaySession().getRestClient().post(url);
    }
}
