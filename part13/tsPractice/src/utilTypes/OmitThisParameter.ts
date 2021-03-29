function OmitThisParameter2Hex(this: Number) {
  return this.toString(16)
}

const five2Hex:OmitThisParameter<typeof OmitThisParameter2Hex>  = OmitThisParameter2Hex.bind(5)
console.log(five2Hex());

