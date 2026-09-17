class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>() ;
String[] parts = path.split("/");

for(String part : parts){
    if(part.equals("") || part.isEmpty()){ }
        else if(part.equals(".")){ }
      else if(part.equals("..")){
    if(!stack.isEmpty()) stack.pop(); 
        }else {
            stack.push(part) ;
        }
}
       List<String> list = new ArrayList<>(stack);
return "/" + String.join("/", list);
    }
}