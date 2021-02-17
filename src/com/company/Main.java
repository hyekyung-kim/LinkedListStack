package com.company;

import java.util.Scanner;

class Node {
    Node next;
    Node pre;
    int data;

    Node(int data){
        this.data = data;
    }
}

class LinkedListStack {
    Node top;
    Node bottom;

    LinkedListStack(){
        top = null;
        bottom = null;
    }

    public boolean isEmpty(){
        return top == null;
    }

    public void push(Node node){
        if(top == null){
            top = node;
            bottom = node;
        }else{
            top.next = node;
            node.pre = top;
            top = node;
        }
    }

    public Node peek(){
        if(isEmpty()){
            return null;
        }else{
            return top;
        }
    }

    public Node pop(){
        if(isEmpty()){
            return null;
        }else{
            Node popNode = top;
            if(top.pre != null) {
                top = top.pre;
                top.next = null;
                popNode.pre = null;
            }else{
                top = null;
                bottom = null;
            }
            return popNode;
        }
    }

    public void search(Node node){
        Node tmp = bottom;
        int idx = 0;

        System.out.print("index is: ");
        while(tmp != null){
            if(node.data == tmp.data){
                System.out.print(idx + " ");
            }
            tmp = tmp.next;
            idx++;
        }
        System.out.println();
    }

    public void printStack(){
        Node tmp = bottom;

        while(tmp != null){
            System.out.print(tmp.data + " ");
            tmp = tmp.next;
        }
        System.out.println();
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // 스택 생성 & 초기화
        LinkedListStack stack = new LinkedListStack();

        // 스택 정보 입력
        System.out.println("\nMENU (1: push | 2: peek | 3: pop | 4: search | 5: print stack | -1: quit)\n");
        int check;
        do{
            System.out.print("what do you want? ");
            check = input.nextInt();

            // 스택 push
            if(check == 1) {
                System.out.print("Input stack element: ");
                int tmp = input.nextInt();
                stack.push(new Node(tmp));
            } // 스택 peek
            else if(check == 2){
                try{
                    System.out.println("peek: " + stack.peek().data);
                }catch(NullPointerException e){
                    System.out.println("Stack is NULL\n");
                }

            } // 스택 pop
            else if(check == 3){
                try {
                    System.out.println("pop: " + stack.pop().data);
                }catch (NullPointerException e){
                    System.out.println("Stack is NULL\n");
                }
            } // 검색
            else if(check == 4){
                System.out.print("Input search element: ");
                int tmp = input.nextInt();
                stack.search(new Node(tmp));
            }else if(check == 5){
                stack.printStack();
            } // 출력
            else if(check == -1){
                System.out.println("exit...");
            } // 예외
            else{
                System.out.println("Command not found.\n");
            }

        } while(check != -1);
    }
}
