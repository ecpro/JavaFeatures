/**
 * Created by eccspro on 28/03/18.
 *
 * Notes :
 *
 Annotations are partly motivated by a general trend toward combining metadata with source-code files,
 instead of keeping it in external documents.

 Web services, custom tag libraries and object/relational mapping tools like Toplink and Hibernate often
 require XML descriptors that are external to the code. After defining a Java class,
 the programmer must undergo the tedium of respecifying information like the name, package and so on.

 Using annotations, however, you can keep all of the information in the source file.

 1. Annotation does not support inheritance
 2. Three retention policy RUNTIME, COMPILE and SOUCE
 *
 */
package com.piyush.annotations.database;

