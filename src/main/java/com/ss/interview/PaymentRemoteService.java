package com.ss.interview;

import java.rmi.Naming;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

/**
 * @author Senn
 * @create 2022/4/6 17:12
 */
public class PaymentRemoteService {
    public static ConsultResult isEnabled(String paymentType) {
        return new ConsultResult();
    }
}
class ConsultResult {
    private boolean isEnabled;
    private String errorCode;

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}

class PaymentClass {

    ExecutorService pool = Executors.newFixedThreadPool(4);

    public List<String> filterDisablePayment(List<String> allPaymentList) throws ExecutionException, InterruptedException {
        List<String> res = new ArrayList<>();
        HashMap<String, Future<ConsultResult>> map = new HashMap<>();
        for (String name : allPaymentList) {
            Future<ConsultResult> future = pool.submit(new Task(name));
            map.put(name, future);
        }
        for (Map.Entry<String, Future<ConsultResult>> entry : map.entrySet()) {
            if (entry.getValue().get().isEnabled()) {
                res.add(entry.getKey());
            }
        }
        return res;
    }
}
class Task implements Callable<ConsultResult> {

    String name;

    public Task(String name) {
        this.name = name;
    }

    @Override
    public ConsultResult call() throws Exception {
        return PaymentRemoteService.isEnabled(name);
    }
}
