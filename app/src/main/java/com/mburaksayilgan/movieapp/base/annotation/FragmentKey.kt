package com.mburaksayilgan.movieapp.base.annotation

import androidx.fragment.app.Fragment
import dagger.MapKey
import kotlin.reflect.KClass


@MapKey
@Target(AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER)
annotation class FragmentKey(val value: KClass<out Fragment>)
