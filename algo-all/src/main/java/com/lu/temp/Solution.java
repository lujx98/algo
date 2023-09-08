package com.lu.temp;

import java.util.concurrent.*;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author sheldon
 * @date 2023-09-08
 */
public class Solution {

    private static final ExecutorService THREAD_POOL = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() + 1);

    public int test(int param1) {
        Double request1 = 1D;
        Double request2 = 1D;
        Double request3 = 1D;
        Double request4 = 1D;

        TestCall testApi1 = new TestCall(request1);
        TestCall testApi2 = new TestCall(request2);
        TestCall testApi3 = new TestCall(request3);
        TestCall testApi4 = new TestCall(request4);

        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(testApi1);
        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(testApi2);
        CompletableFuture<Integer> future3 = CompletableFuture.supplyAsync(testApi3);
        CompletableFuture<Integer> future4 = CompletableFuture.supplyAsync(testApi4);

        return param1;
    }

    public static class TestCall extends ExternalCall<Double, Integer> {

        @Override
        protected Integer doCall(Double request) {
            return null;
        }

        public TestCall(Double request) {
            setRequest(request);
        }
    }

    public static abstract class ExternalCall<T, R> implements Supplier<R> {

        private T request;

        @Override
        public R get() {
            preCall(request);
            R res = doCall(request);
            afterCall(request, res);
            return res;
        }

        private void preCall(T request) {

        }

        private void afterCall(T request, R res) {

        }

        protected void setRequest(T request) {
            this.request = request;
        }

        protected abstract R doCall(T request);

    }

}
