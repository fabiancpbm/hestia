/* Initial beliefs and rules */
connected(true).

/* Initial goals */
!start.

/* Plans */
+!start : true <- 
	.print("Hello World!").