export function paddingLeft(padding: number | string, input: string) {
  if (typeof padding==='number') {
    return new Array(padding + 1).join(" ") + input;
  }
  return padding + input;
}


