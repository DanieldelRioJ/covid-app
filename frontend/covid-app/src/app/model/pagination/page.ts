export interface Page<T>{
  content: T,
  totalElements: number;
  last:boolean;
  totalPages: number;
  sort: {unsorted:boolean, sorted:boolean, empty:boolean};
  numberOfElements: number;
  first:boolean;
  size:number;
  number: number;
  empty: boolean;
}
