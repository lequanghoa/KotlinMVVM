package rx.mvvm

import java.lang.ref.WeakReference
import java.util.*

class Cache<M : Model<K>, K> {
    private val cache = WeakHashMap<K, WeakReference<M>>()

    fun getAll(): List<M> {
        return cache.values.map { it.get() }.filterNotNull()
    }

    fun getAndPut(key: K, creator: (K) -> M): M {
        return get(key) ?: creator(key).apply { put(this) }
    }

    fun get(key: K): M? {
        return cache[key]?.get()
    }

    fun put(model: M) {
        cache[model.id] = WeakReference(model)
    }
}
