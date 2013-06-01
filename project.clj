(defproject lein-checkall "0.1.1"
  :description "lein check && lein kibit && lein eastwood && lein bikeshed"
  :url "http://lein-checkall.itang.me"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.4.0"]
                 [lein-kibit "0.0.8"]
                 [jonase/eastwood "0.0.2"]
                 [lein-bikeshed "0.1.3"]]
  :eval-in-leiningen true
  :pom-addition [:developers [:developer
                              [:id "itang"]
                              [:name "唐古拉山"]
                              [:url "http://www.itang.me"]
                              [:email "live.tang@gmail.com"]]])
