#include <stdio.h>

#include <stdlib.h>

#include <string.h>

int main()

{

   char command[100];
   char arg1[50]; 
   char arg2[50];

    do{
        printf("\nPlease enter your DOS command; you may press ctrl-c to exit: ");
        
        scanf("%s", command);
        
        
         switch(command[0]){ //we are using each case statement to read a character in one at a time

           case 'd':

               switch(command[1]){

                   case 'e':

                       switch(command[2]){

                           case 'l':
                           scanf("%s", arg1);
                           strcpy(command, "rm ");
                           strcat(command, arg1);
                           system(command);
                           printf("\nfile successfully deleted");
                           break;
               }
               
               case 'i': //since d has already been used, we can continue this case statement in an alternative path
                    switch(command[2]){
                        case 'r':
                        system("ls");
                        break;
                    }
               }
              
            break; 
            
            
            case 'c':
        
            switch(command[1]){
                case 'd':
                    scanf("%s", arg1);
                    strcpy(command, "cd ");
                    strcat(command, arg1);
                    system(command);
                    printf("Directory successfully changed: ");
                    break; 
                case 'o':
        
            switch(command[2]){
                case 'p':
        
                switch(command[3]){
                    case 'y':
                    scanf("%s", arg1);
                    scanf("%s", arg2);
                    strcpy(command, "cp ");
                    strcat(command, arg1);
                    printf("\nfile successfully copied");
                    break;
                }
            }
       break;
       }
  break; 

            
        
            
            case 't':
            
            switch(command[1]){
                case 'y':
                switch(command[2]){
                    case 'p':
                    switch(command[3]){
                        case 'e': //Type(e.g. type >file1) desired text and then press CTRL-D to exit and save file
                        scanf("%s", arg1);
                        strcpy(command, "cat ");
                        strcat(command, arg1);
                        system(command);
                        printf("file successfully created");
                        break; 
                    }
                break;
                }
            break;
            }
        break;
    
    

        case 'r':
        
        switch(command[1]){
            case 'e':
            
            switch(command[2]){
                case 'n':
                scanf("%s", arg1);
                scanf("%s", arg2);
                strcpy(command, "mv ");
                strcat(command, arg1);
                strcat(command, " ");
                strcat(command, arg2);
                system(command); 
                printf("file successfully renamed");
                break; 
            }
        break; 
        }
    break;



           

    default: //if the case statements fail 
        printf("\nThe command inputted is not accepted"); //when input is invalid 
        printf("\nYou must type the commmands cd, dir, type, del, ren, or copy"); //valid inputs 
    }
} while(255);

    exit(0); //exit code 
}
