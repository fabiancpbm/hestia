/* Initial beliefs and rules */
it-is-clear(yes).

/* Initial goals */
!start.

/* Plans */
+!start : true <- 
	.print("Hello World!").