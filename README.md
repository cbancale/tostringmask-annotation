# @ToStringMask Annotation

A Java annotation used to mask information when logging model objects

## Usage

1. Have your model class extend `com.cbancale.tostringmask.MaskedBaseModel`

1. Apply `@ToStringMask` to fields that you want to mask when logging `<model object>.toString()`

## Types of Masks

Preset rules for masking are available in `com.cbancale.tostringmask.MaskType`

1. `FULL` - masks all characters

1. `EMAIL` - masks all characters to the left of `@`

1. `SSN` - follows the scheme: `XXX-XX-XXXX`. Masks all numeric characters before the final four digits

1. `CUSTOM` - use when a custom masking rule is needed. `@ToStringMask` accepts a `len` parameter that determines how many characters are masked when `CUSTOM` is used. If `len` is not provided, 10 characters are masked
