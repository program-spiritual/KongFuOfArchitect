[1, 2, 3].map(num => {
  if (typeof num === "number") return;
  return num * 2;
});
