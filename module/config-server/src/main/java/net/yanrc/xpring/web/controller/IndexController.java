package net.yanrc.xpring.web.controller;

import com.netflix.config.DynamicPropertyFactory;
import net.yanrc.xpring.dal.entity.ConfigPropertity;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.observables.AsyncOnSubscribe;
import rx.observables.BlockingObservable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/30.
 */
@Controller
public class IndexController implements InitializingBean {
    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @RequestMapping(value = "/api/index", method = RequestMethod.GET)
    public String index1() {
        System.out.println(DynamicPropertyFactory.getInstance().getStringProperty("demo.url.user.name", "yanrc11").getValue());
        return "home";
    }

    @RequestMapping(value = {"/index", "/"}, method = RequestMethod.GET)
    public String index() {
        System.out.println(DynamicPropertyFactory.getInstance().getStringProperty("demo.url.user.name", "yanrc11").getValue());
        return "home";
    }

    @RequestMapping(value = "demo6", method = RequestMethod.GET)
    public String demo6() {
        ConfigPropertity  cp = new ConfigPropertity();
        Observable<ConfigPropertity> observable = Observable.just(cp);
        BlockingObservable<ConfigPropertity> blaBlockingObservable = observable.toBlocking();
        blaBlockingObservable.forEach(new Action1<ConfigPropertity>() {
            @Override
            public void call(ConfigPropertity s) {
                logger.info("demo6,call");
            }
        });

        blaBlockingObservable.subscribe(new Observer<ConfigPropertity>() {
            @Override
            public void onCompleted() {
                logger.info("demo6,onCompleted");
            }

            @Override
            public void onError(Throwable e) {
            }

            @Override
            public void onNext(ConfigPropertity s) {
                logger.info("demo6 onNext={}", s);
            }
        });
        blaBlockingObservable.subscribe(new Observer<ConfigPropertity>() {
            @Override
            public void onCompleted() {
                logger.info("demo6-1,onCompleted");
            }

            @Override
            public void onError(Throwable e) {
            }

            @Override
            public void onNext(ConfigPropertity s) {
                logger.info("demo6-1 onNext={}", s);
            }
        });
        blaBlockingObservable.subscribe(new Observer<ConfigPropertity>() {
            @Override
            public void onCompleted() {
                logger.info("demo6-2,onCompleted");
            }

            @Override
            public void onError(Throwable e) {
            }

            @Override
            public void onNext(ConfigPropertity s) {
                logger.info("demo6-2 onNext={}", s);
            }
        });
        blaBlockingObservable.subscribe(new Observer<ConfigPropertity>() {
            @Override
            public void onCompleted() {
                logger.info("demo6-3,onCompleted");
            }

            @Override
            public void onError(Throwable e) {
            }

            @Override
            public void onNext(ConfigPropertity s) {
                logger.info("demo6-3 onNext={}", s);
            }
        });

        logger.info("demo6 finish");
        return "home";
    }

    @RequestMapping(value = "demo5", method = RequestMethod.GET)
    public String demo5() {
        Observable<Integer> observable1 = Observable.just(1, 3, 5, 7);
        Observable<Integer> observable2 = Observable.just(2, 4, 6, 9, 10);
        Observable.zip(observable1, observable2, new Func2<Integer, Integer, Integer>() {
            @Override
            public Integer call(Integer integer, Integer integer2) {
                return integer + integer2;
            }
        })
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onCompleted() {
                        logger.info("demo5,onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onNext(Integer integer) {
                        logger.info("demo5 onNext={}", integer);
                    }
                });
        return "home";
    }

    //http://wuxiaolong.me/2016/01/18/rxjava/
    @RequestMapping(value = "demo4", method = RequestMethod.GET)
    public String demo4() {
        Observable.just(1, 2, 3, 4, 5)
                .scan(new Func2<Integer, Integer, Integer>() {
                    @Override
                    public Integer call(Integer integer, Integer integer2) {
                        return integer + integer2;
                    }
                })
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onCompleted() {
                        logger.info("demo4,onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onNext(Integer integer) {
                        logger.info("demo4 onNext={}", integer);
                    }
                });
        return "home";
    }

    @RequestMapping(value = "demo3", method = RequestMethod.GET)
    public String demo3() {
        List<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("RxJava");
        Observable.from(list)
                .flatMap(new Func1<String, Observable<String>>() {
                    @Override
                    public Observable<String> call(String s) {
                        return Observable.just(s.toUpperCase());
                    }
                })
                .subscribe(new Observer<String>() {
                    @Override
                    public void onCompleted() {
                        logger.info("demo3,onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onNext(String s) {
                        logger.info("demo3 onNext={}", s);
                    }
                });
        return "home";
    }

    @RequestMapping(value = "demo2", method = RequestMethod.GET)
    public String demo2() {
        Observable.just("Hello", "RxJava")
                .map(new Func1<String, String>() {
                    @Override
                    public String call(String s) {
                        return s.toUpperCase();
                    }
                })
                .subscribe(new Observer<String>() {
                    @Override
                    public void onCompleted() {
                        logger.info("demo2 onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        logger.error("捕捉到错误", e);
                    }

                    @Override
                    public void onNext(String s) {
                        logger.info("demo2 onNext:{}", s);
                    }
                });
        return "home";
    }

    @RequestMapping(value = "demo1", method = RequestMethod.GET)
    public String demo1() {
        Observable<String> observable;

//        observable = Observable.create(new Observable.OnSubscribe<String>() {
//            @Override
//            public void call(Subscriber<? super String> subscriber) {
//                subscriber.onNext("11");
//                subscriber.onNext("22");
//                subscriber.onNext("33");
//                subscriber.onCompleted();
//            }
//        });
////
//        String[] froms = {"1","2","3","4","5","6","7","8","9","a","b","c"};
//        observable = Observable.from(froms);

        observable = Observable.just("11", "22");

        observable.subscribe(new Observer<String>() {
            @Override
            public void onCompleted() {
                logger.info("demo1 onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                logger.error("捕捉到错误", e);
            }

            @Override
            public void onNext(String s) {
                logger.info("demo1 onNext={}", s);
                if (!StringUtils.equalsIgnoreCase(s, "11")) {
                    throw new RuntimeException("未知错误");
                }
            }
        });
        observable.subscribe(new Observer<String>() {
            @Override
            public void onCompleted() {
                logger.info("demo2 onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                logger.error("demo2 onError", e);
            }

            @Override
            public void onNext(String s) {
                logger.info("demo2 onNext={}", s);
            }
        });
        observable.subscribe(new Observer<String>() {
            @Override
            public void onCompleted() {
                logger.info("demo3 onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                logger.error("demo3 onError", e);
            }

            @Override
            public void onNext(String s) {
                logger.info("demo3 onNext={}", s);
            }
        });

        observable.subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {
                logger.info("demo4 onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                logger.error("demo4 onError", e);
            }

            @Override
            public void onNext(String s) {
                logger.info("demo4 onNext={}", s);
            }
        });

        return "home";
    }

    @Override
    public void afterPropertiesSet() throws Exception {
//        FixedDelayPollingScheduler scheduler = new FixedDelayPollingScheduler(60000, 30000, true);
//        URLConfigurationSource urlConfigurationSource = new URLConfigurationSource("http://localhost:7089/config.properties");
//        DynamicConfiguration configuration = new DynamicConfiguration(urlConfigurationSource, scheduler);
//        ConfigurationManager.install(configuration);
    }
}
