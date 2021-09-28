export class InsightAddress {
  private readonly _street: string;
  private readonly _zip: string;
  private readonly _city: string;
  private readonly _country: string;

  constructor(street: string, zip: string, city: string, country: string) {
    this._street = street;
    this._zip = zip;
    this._city = city;
    this._country = country;
  }

  get street(): string {
    return this._street;
  }

  get zip(): string {
    return this._zip;
  }

  get city(): string {
    return this._city;
  }

  get country(): string {
    return this._country;
  }
}
