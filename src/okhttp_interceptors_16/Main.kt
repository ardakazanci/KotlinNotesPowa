package okhttp_interceptors_16


import okhttp3.*
import java.util.concurrent.TimeUnit


// OkHttp ' ye Interceptor Eklemek için addInterceptor metodu kullanılır.
fun myHttpClient(): OkHttpClient {
    val builder = OkHttpClient().newBuilder()
        .addInterceptor(MyInterceptor())
    // .addInterceptor(MyInterceptor()) -> Görüldüğü üzere oluşturduğumuz interceptor eklenir.
    return builder.build()
}

// Interceptor oluşturmak için Interceptor'dan extends edilir.
class MyInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        /**
         * API Çağrımız burada ele geçirilecek
         */
    }
}


// ÖRNEK 1 --- Gerçek Kullanım Senaryoları
//ANDROID PROGRAMLAMA -  Hataları merkezi olarak günlüğe kaydetme
class ErrorInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {

        val request: Request = chain.request()
        val response = chain.proceed(request) // Sunucudan alınan yanıt
        // Interface kullanarak veya RxJava, EventBus vb. Bir şey kullanarak hatayı görünüme aktarabiliriz.
        when (response.code()) {
            400 -> {
                //Bad Request Hata Mesajı
            }
            401 -> {
                // Unauthorized Hata Mesajı
                /**
                Diyelim ki 401 hatası alırsak ( yani yetkisiz) , uygulama verilerini temizlemek /
                kullanıcı oturumunu kapatmak ya da gerçekleştirmek
                istediğimiz herhangi bir eylemi temizlemek için bir eylem gerçekleştirebiliriz.
                 */
            }

            403 -> {
                //Forbidden Hata Mesajı
            }

            404 -> {
                // NotFound hata mesajı
            }

            // ...diğerleri

        }
        return response
    }
}

// ÖRNEK 2 --- Gerçek Kullanım Senaryoları
// Yanıtı ÖnBelleğe Almak
// API Çağrısını ÖnBelleğe almak için OkHttpCore için bir Interceptor yazabiliriz.
// Cache-Control mekanizması sunucu tarafında etkileştirilmelidir. Etkinleştirilmemişse yine de yapılabilir.
// Dikkat edilecek nokta OkHttpClient içeisine addNetworkInterceptor diyerek çağırabiliriz.
class CacheInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val response: Response = chain.proceed(chain.request()) // Response alınır.
        // Cache-Control eklenir. ve döndürülür.
        val cacheControl = CacheControl.Builder()
            .maxAge(10, TimeUnit.DAYS)
            .build()
        return response.newBuilder()
            .header("Cache-Control", cacheControl.toString())
            .build()
    }
}

class ForceCacheInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val builder: Request.Builder = chain.request().newBuilder()
        if (!IsInternetAvailable()) { // Internet kullanılmıyorsa
            builder.cacheControl(CacheControl.FORCE_CACHE);

        }
        return chain.proceed(builder.build());
    }
}

// ÖRNEK 3 --- Gerçek Kullanım Senaryoları
// Access Token Üst Bilgisini Eklemek
class AuthTokenInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {

        val originalRequest = chain.request()
        val requestBuilder = originalRequest.newBuilder()
            .header("Authorization", "AuthToken")
        val request = requestBuilder.build()
        return chain.proceed(request)
    }
}

// ÖRNEK 4 ---- GERÇEK KULLANIM SENARYOLARI
// Eğer ki Access Token ' ı yenilemek istersek
override fun intercept(chain: Interceptor.Chain): Response {

    val accessToken = //our access Token
    val request = chain.request().newBuilder()
        .addHeader("Authorization", accessToken)
        .build()
    val response = chain.proceed(request)

    if (response.code() == 401) {
        val newToken: String = //fetch from some other source
            if (newToken != null) {
                val newRequest = chain.request().newBuilder()
                    .addHeader("Authorization", newToken)
                    .build()
                return chain.proceed(newRequest)
            }
    }

    return response
}



