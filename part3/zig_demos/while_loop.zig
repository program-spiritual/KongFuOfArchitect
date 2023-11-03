const std = @import("std");
test "while" {
  var i :u8 =2;
  while (i<100) {
    i*=2;
  }
  try std.testing.expect(i==128);
}

test "while with continue expression" {
    var sum :u8=0;
    var i :u8 = 1;
    while (i<=10) : (i+=1){sum+=i;}
    try std.testing.expect(sum==55);
}

test "while with continue" {
    var sum :u8=0;
    var i :u8 = 1;
    while (i<=3) : (i+=1){
         if (i==2) continue;
         sum+=i;
     }
     try std.testing.expect(sum==4);
 }

 test "while with break" {
     var sum :u8=0;
     var i :u8 = 1;
     while (i<=3) : (i+=1){
         if (i==2) break;
         sum+=i;
     }
     try std.testing.expect(sum==1);
 }