function toHex(this: Number) {
  return this.toString(16)
}

function number2String(n:ThisParameterType<typeof toHex>) {
  return toHex.apply(n);
}
