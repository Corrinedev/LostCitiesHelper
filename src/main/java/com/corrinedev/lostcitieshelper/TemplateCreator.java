package com.corrinedev.lostcitieshelper;

import javafx.stage.DirectoryChooser;

import javax.swing.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TemplateCreator {

    public static void createTemplates() {

        JOptionPane.showMessageDialog(null,"Choose the directory you want to make the lostcities datapack in, if you're using kubejs you will want this to point to your kubejs/data folder");
        DirectoryChooser directoryChooser = new DirectoryChooser();

        String directory = String.valueOf(directoryChooser.showDialog(null));

        System.out.println(directory);

        if(!(directory == null)) {

            try {
                Files.createDirectory(Path.of(directory + "/lostcities"));
                Files.createDirectory(Path.of(directory + "/lostcities/lostcities"));
                Files.createDirectory(Path.of(directory + "/lostcities/loot_tables"));
                Files.writeString(Path.of(directory + "/lostcities/loot_tables/lostcitychest.json"), """
                        {
                          "pools": [
                            {
                              "name": "lostcities:lostcitychest",
                              "rolls": {
                                "min": 2,
                                "max": 4
                              },
                              "entries": [
                                {
                                  "type": "item",
                                  "name": "minecraft:diamond_sword",
                                  "functions": [
                                    {
                                      "function": "set_count",
                                      "count": {
                                        "min": 0,
                                        "max": 1
                                      }
                                    }
                                  ],
                                  "weight": 2
                                },
                                {
                                  "type": "item",
                                  "name": "minecraft:gold_ingot",
                                  "functions": [
                                    {
                                      "function": "set_count",
                                      "count": {
                                        "min": 1,
                                        "max": 5
                                      }
                                    }
                                  ],
                                  "weight": 5
                                },
                                {
                                  "type": "item",
                                  "name": "minecraft:diamond",
                                  "functions": [
                                    {
                                      "function": "set_count",
                                      "count": {
                                        "min": 1,
                                        "max": 5
                                      }
                                    }
                                  ],
                                  "weight": 5
                                },
                                {
                                  "type": "item",
                                  "name": "minecraft:emerald",
                                  "functions": [
                                    {
                                      "function": "set_count",
                                      "count": {
                                        "min": 1,
                                        "max": 3
                                      }
                                    }
                                  ],
                                  "weight": 5
                                }
                              ]
                            }
                          ]
                        }""");
                directory = directory + "/lostcities/lostcities";
                Files.createDirectory(Path.of(directory + "/buildings"));
                Files.writeString(Path.of(directory + "/buildings/cabin.json"), """
                        {
                          "filler": "#",
                          "rubble": "}",
                          "minfloors": 1,
                          "maxfloors": 1,
                          "parts": [
                            {
                              "part": "cabin"
                            }
                          ]
                        }""");
                Files.writeString(Path.of(directory + "/buildings/building_example.json"), """
                        {
                          "filler": "#",
                          "rubble": "}",
                          "parts": [
                            {
                              "top": false,
                              "part": "building1_1"
                            },
                            {
                              "top": false,
                              "part": "building1_2"
                            },
                            {
                              "top": false,
                              "part": "building1_3"
                            },
                            {
                              "top": true,
                              "part": "top1x1_1"
                            }
                          ]
                        }""");
                Files.createDirectory(Path.of(directory + "/citystyles"));
                Files.writeString(Path.of(directory + "/citystyles/citystyle_config.json"), """
                        {
                          "streetblocks": {
                            "width": 8
                          }
                        }
                        """);
                Files.writeString(Path.of(directory + "/citystyles/citystyle_common.json"), """
                        {
                            "inherit": "citystyle_config",
                            "stuff_tags": [
                                "rubble"
                            ],
                            "streetblocks": {
                                "border": "y",
                                "wall": "w",
                                "street": "S",
                                "streetbase": "b",
                                "streetvariant": "B"
                            },
                            "parkblocks": {
                                "elevation": "x"
                            },
                            "corridorblocks": {
                                "roof": "x",
                                "glass": "+"
                            },
                            "railblocks": {
                                "railmain": "y"
                            },
                            "sphereblocks": {
                                "glass": "Z",
                                "border": "9",
                                "inner": "b"
                            },
                            "selectors": {
                                "buildings": [
                                    {
                                        "factor": 0.3,
                                        "value": "building_example"
                                    }
                                ],
                                "multibuildings": [
                                    {
                                        "factor": 0.3,
                                        "value": "multi_example"
                                    }
                                ],
                                "bridges": [
                                    {
                                        "factor": 1,
                                        "value": "bridge_open"
                                    },
                                    {
                                        "factor": 1,
                                        "value": "bridge_covered"
                                    }
                                ],
                                "fronts": [
                                    {
                                        "factor": 1,
                                        "value": "building_front_example"
                                    }
                                ],
                                "stairs": [
                                    {
                                        "factor": 1,
                                        "value": "stairs1"
                                    },
                                    {
                                        "factor": 1,
                                        "value": "stairs2"
                                    },
                                    {
                                        "factor": 1,
                                        "value": "stairsnormal"
                                    },
                                    {
                                        "factor": 1,
                                        "value": "stairsbig"
                                    }
                                ],
                                "fountains": [
                                    {
                                        "factor": 1,
                                        "value": "fountain_example"
                                    }
                                ],
                                "parks": [
                                    {
                                        "factor": 1,
                                        "value": "park_example"
                                    }
                                ],
                                "raildungeons": [
                                  {
                                    "factor": 1.0,
                                    "value": "rail_dungeon1"
                                  }
                                ]
                            }
                        }""");
                Files.createDirectory(Path.of(directory + "/conditions"));
                Files.writeString(Path.of(directory + "/conditions/easymobs.json"), """
                        {
                          "values": [
                            {
                              "factor": 1,
                              "value": "minecraft:zombie"
                            }
                          ]
                        }
                        """);
                Files.writeString(Path.of(directory + "/conditions/chestloot.json"), """
                        {
                            "values": [
                                {
                                    "factor": 1,
                                    "value": "lostcities:lostcitychest"
                                }
                            ]
                        }""");
                Files.createDirectory(Path.of(directory + "/multibuildings"));
                Files.writeString(Path.of(directory + "/multibuildings/multi_example.json"), """
                        {
                          "dimx": 2,
                          "dimz": 2,
                          "buildings": [
                            [
                              "building_example",
                              "building_example"
                            ],
                            [
                              "building_example",
                              "building_example"
                            ]
                          ]
                        }
                        """);
                Files.createDirectory(Path.of(directory + "/palettes"));
                Files.writeString(Path.of(directory + "/palettes/rails.json"), """
                        {
                          "palette": [
                            {
                              "char": "k",
                              "block": "minecraft:rail[shape=north_south]"
                            },
                            {
                              "char": "e",
                              "block": "minecraft:rail[shape=east_west]"
                            },
                            {
                              "char": "j",
                              "block": "minecraft:rail[shape=ascending_east]"
                            },
                            {
                              "char": "q",
                              "block": "minecraft:rail[shape=south_east]"
                            },
                            {
                              "char": "s",
                              "block": "minecraft:rail[shape=south_west]"
                            },
                            {
                              "char": "r",
                              "block": "minecraft:rail[shape=north_west]"
                            },
                            {
                              "char": "n",
                              "block": "minecraft:rail[shape=north_east]"
                            },
                            {
                              "char": "m",
                              "block": "minecraft:powered_rail[powered=true,shape=north_south]"
                            },
                            {
                              "char": "E",
                              "block": "minecraft:powered_rail[powered=true,shape=ascending_south]"
                            },
                            {
                              "char": "H",
                              "block": "minecraft:powered_rail[powered=true,shape=ascending_north]"
                            },
                            {
                              "char": "f",
                              "block": "minecraft:powered_rail[powered=true,shape=east_west]"
                            },
                            {
                              "char": "i",
                              "block": "minecraft:powered_rail[powered=true,shape=ascending_east]"
                            }
                          ]
                        }
                        """);
                Files.writeString(Path.of(directory + "/palettes/glass_side_variant_bricks.json"), """
                        {
                          "palette": [
                            {
                              "char": "@",
                              "frompalette": "#"
                            }
                          ]
                        }
                        """);
                Files.writeString(Path.of(directory + "/palettes/glass_full.json"), """
                        {
                          "palette": [
                            {
                              "char": "+",
                              "block": "minecraft:glass"
                            },
                            {
                              "char": "`",
                              "block": "minecraft:glass_pane"
                            },
                            {
                              "char": "a",
                              "block": "minecraft:glass"
                            }
                          ]
                        }
                        """);
                Files.writeString(Path.of(directory + "/palettes/bricks_standard.json"), """
                        {
                          "palette": [
                            {
                              "char": "X",
                              "block": "minecraft:infested_stone_bricks",
                              "damaged": "minecraft:iron_bars"
                            },
                            {
                              "char": "$",
                              "block": "minecraft:smooth_stone_slab[type=double]",
                              "damaged": "minecraft:iron_bars"
                            },
                            {
                              "char": "#",
                              "variant": "stonebrick",
                              "damaged": "minecraft:iron_bars"
                            },
                            {
                              "char": "}",
                              "variant": "stonebrick_rubble",
                              "damaged": "minecraft:iron_bars"
                            }
                          ]
                        }
                        """);
                Files.writeString(Path.of(directory + "/palettes/default_desert.json"), """
                        {
                          "palette": [
                            {
                              "char": "Q",
                              "block": "minecraft:quartz_block",
                              "damaged": "minecraft:iron_bars"
                            },
                            {
                              "char": "R",
                              "block": "minecraft:cyan_terracotta",
                              "damaged": "minecraft:iron_bars"
                            },
                            {
                              "char": "u",
                              "block": "minecraft:smooth_stone_slab[type=double]",
                              "damaged": "minecraft:iron_bars"
                            },
                            {
                              "char": "S",
                              "block": "minecraft:red_sandstone_slab[type=double]",
                              "damaged": "minecraft:iron_bars"
                            },
                            {
                              "char": "b",
                              "block": "minecraft:structure_void"
                            },
                            {
                              "char": "B",
                              "block": "minecraft:red_nether_bricks",
                              "damaged": "minecraft:iron_bars"
                            },
                            {
                              "char": "v",
                              "blocks": [
                                {
                                  "random": 10,
                                  "block": "minecraft:cracked_stone_bricks"
                                },
                                {
                                  "random": 9,
                                  "block": "minecraft:mossy_stone_bricks"
                                },
                                {
                                  "random": 2000,
                                  "block": "minecraft:stone_bricks"
                                }
                              ],
                              "damaged": "minecraft:iron_bars"
                            },
                            {
                              "char": "y",
                              "blocks": [
                                {
                                  "random": 10,
                                  "block": "minecraft:cracked_stone_bricks"
                                },
                                {
                                  "random": 9,
                                  "block": "minecraft:mossy_stone_bricks"
                                },
                                {
                                  "random": 2000,
                                  "block": "minecraft:stone_bricks"
                                }
                              ],
                              "damaged": "minecraft:iron_bars"
                            },
                            {
                              "char": "x",
                              "block": "minecraft:cut_sandstone"
                            },
                            {
                              "char": "_",
                              "block": "minecraft:smooth_stone_slab[type=bottom]"
                            },
                            {
                              "char": "=",
                              "block": "minecraft:smooth_stone_slab[type=bottom]"
                            },
                            {
                              "char": "w",
                              "block": "minecraft:cobblestone_wall"
                            },
                            {
                              "char": ":",
                              "block": "minecraft:iron_bars"
                            },
                            {
                              "char": "A",
                              "block": "minecraft:stone_brick_stairs[facing=west,half=bottom,shape=straight]"
                            },
                            {
                              "char": "t",
                              "block": "minecraft:stone_brick_stairs[facing=east,half=bottom,shape=straight]"
                            },
                            {
                              "char": "z",
                              "block": "minecraft:stone_brick_stairs[facing=north,half=bottom,shape=straight]"
                            },
                            {
                              "char": "c",
                              "block": "minecraft:stone_brick_stairs[facing=south,half=bottom,shape=straight]"
                            },
                            {
                              "char": "d",
                              "block": "minecraft:stone_brick_stairs[facing=north,half=top,shape=straight]"
                            },
                            {
                              "char": "(",
                              "block": "minecraft:quartz_stairs[facing=north,half=bottom,shape=straight]"
                            },
                            {
                              "char": ")",
                              "block": "minecraft:quartz_stairs[facing=south,half=bottom,shape=straight]"
                            },
                            {
                              "char": "/",
                              "block": "minecraft:stone_stairs[facing=west,half=bottom,shape=straight]"
                            }
                          ]
                        }
                        """);
                Files.writeString(Path.of(directory + "/palettes/default.json"), """
                        {
                          "palette": [
                            {
                              "char": "R",
                              "block": "minecraft:cyan_terracotta",
                              "damaged": "minecraft:iron_bars"
                            },
                            {
                              "char": ";",
                              "block": "minecraft:furnace",
                              "damaged": "minecraft:iron_bars",
                              "tag": {
                                "Items": [
                                  {
                                    "Slot": 0,
                                    "id": "minecraft:coal",
                                    "Count": 10
                                  }
                                ]
                              }
                            },
                            {
                              "char": "Q",
                              "block": "minecraft:quartz_block",
                              "damaged": "minecraft:iron_bars"
                            },
                            {
                              "char": "u",
                              "block": "minecraft:smooth_stone_slab[type=double]",
                              "damaged": "minecraft:iron_bars"
                            },
                            {
                              "char": "S",
                              "block": "minecraft:smooth_stone_slab[type=double]",
                              "damaged": "minecraft:iron_bars"
                            },
                            {
                              "char": "b",
                              "block": "minecraft:structure_void"
                            },
                            {
                              "char": "B",
                              "block": "minecraft:bricks",
                              "damaged": "minecraft:iron_bars"
                            },
                            {
                              "char": "v",
                              "variant": "stonebrick",
                              "damaged": "minecraft:iron_bars"
                            },
                            {
                              "char": "y",
                              "variant": "stonebrick",
                              "damaged": "minecraft:iron_bars"
                            },
                            {
                              "char": "x",
                              "variant": "stonebrick",
                              "damaged": "minecraft:iron_bars"
                            },
                            {
                              "char": "_",
                              "block": "minecraft:smooth_stone_slab[type=bottom]"
                            },
                            {
                              "char": "=",
                              "block": "minecraft:smooth_stone_slab[type=bottom]"
                            },
                            {
                              "char": "w",
                              "block": "minecraft:cobblestone_wall"
                            },
                            {
                              "char": ":",
                              "block": "minecraft:iron_bars"
                            },
                            {
                              "char": "A",
                              "block": "minecraft:stone_brick_stairs[facing=west,half=bottom,shape=straight]"
                            },
                            {
                              "char": "t",
                              "block": "minecraft:stone_brick_stairs[facing=east,half=bottom,shape=straight]"
                            },
                            {
                              "char": "z",
                              "block": "minecraft:stone_brick_stairs[facing=north,half=bottom,shape=straight]"
                            },
                            {
                              "char": "c",
                              "block": "minecraft:stone_brick_stairs[facing=south,half=bottom,shape=straight]"
                            },
                            {
                              "char": "d",
                              "block": "minecraft:stone_brick_stairs[facing=north,half=top,shape=straight]"
                            },
                            {
                              "char": "(",
                              "block": "minecraft:quartz_stairs[facing=north,half=bottom,shape=straight]"
                            },
                            {
                              "char": ")",
                              "block": "minecraft:quartz_stairs[facing=south,half=bottom,shape=straight]"
                            },
                            {
                              "char": "/",
                              "block": "minecraft:stone_stairs[facing=west,half=bottom,shape=straight]"
                            }
                          ]
                        }""");
                Files.writeString(Path.of(directory + "/palettes/common.json"), """
                        {
                          "palette": [
                            {
                              "char": "1",
                              "block": "minecraft:spawner",
                              "mob": "easymobs"
                            },
                            {
                              "char": "4",
                              "block": "minecraft:spawner",
                              "mob": "hardmobs"
                            },
                            {
                              "char": "T",
                              "block": "minecraft:wall_torch[facing=north]",
                              "torch": true
                            },
                            {
                              "char": "h",
                              "block": "minecraft:glowstone"
                            },
                            {
                              "char": "g",
                              "block": "minecraft:redstone_torch[lit=true]"
                            },
                            {
                              "char": "9",
                              "blocks": [
                                {
                                  "random": 32,
                                  "block": "minecraft:cyan_terracotta"
                                },
                                {
                                  "random": 32,
                                  "block": "minecraft:gray_terracotta"
                                },
                                {
                                  "random": 32,
                                  "block": "minecraft:cyan_concrete"
                                },
                                {
                                  "random": 1000,
                                  "block": "minecraft:gray_concrete"
                                }
                              ]
                            },
                            {
                              "char": "Y",
                              "block": "minecraft:white_stained_glass"
                            },
                            {
                              "char": "Z",
                              "blocks": [
                                {
                                  "random": 32,
                                  "block": "minecraft:glass"
                                },
                                {
                                  "random": 32,
                                  "block": "minecraft:gray_stained_glass"
                                },
                                {
                                  "random": 32,
                                  "block": "minecraft:blue_stained_glass"
                                },
                                {
                                  "random": 1000,
                                  "block": "minecraft:light_blue_stained_glass"
                                }
                              ]
                            },
                            {
                              "char": "p",
                              "blocks": [
                                {
                                  "random": 30,
                                  "block": "minecraft:poppy"
                                },
                                {
                                  "random": 30,
                                  "block": "minecraft:dandelion"
                                },
                                {
                                  "random": 15,
                                  "block": "minecraft:oak_sapling[stage=1]"
                                },
                                {
                                  "random": 15,
                                  "block": "minecraft:spruce_sapling[stage=1]"
                                },
                                {
                                  "random": 15,
                                  "block": "minecraft:birch_sapling[stage=1]"
                                },
                                {
                                  "random": 1000,
                                  "block": "minecraft:acacia_sapling[stage=1]"
                                }
                              ]
                            },
                            {
                              "char": "K",
                              "blocks": [
                                {
                                  "random": 64,
                                  "block": "minecraft:poppy"
                                },
                                {
                                  "random": 1000,
                                  "block": "minecraft:dandelion"
                                }
                              ]
                            },
                            {
                              "char": "!",
                              "blocks": [
                                {
                                  "random": 15,
                                  "block": "minecraft:diamond_block"
                                },
                                {
                                  "random": 20,
                                  "block": "minecraft:gold_block"
                                },
                                {
                                  "random": 15,
                                  "block": "minecraft:emerald_block"
                                },
                                {
                                  "random": 1000,
                                  "block": "minecraft:iron_block"
                                }
                              ]
                            },
                            {
                              "char": "F",
                              "blocks": [
                                {
                                  "random": 25,
                                  "block": "minecraft:furnace[facing=north]"
                                },
                                {
                                  "random": 20,
                                  "block": "minecraft:crafting_table"
                                },
                                {
                                  "random": 7,
                                  "block": "minecraft:brewing_stand"
                                },
                                {
                                  "random": 6,
                                  "block": "minecraft:anvil[facing=north]"
                                },
                                {
                                  "random": 5,
                                  "block": "minecraft:cauldron"
                                },
                                {
                                  "random": 2,
                                  "block": "minecraft:enchanting_table"
                                },
                                {
                                  "random": 1000,
                                  "block": "minecraft:cobweb"
                                }
                              ]
                            },
                            {
                              "char": "%",
                              "blocks": [
                                {
                                  "random": 40,
                                  "block": "minecraft:cobweb"
                                },
                                {
                                  "random": 1000,
                                  "block": "minecraft:air"
                                }
                              ]
                            },
                            {
                              "char": "\\\\",
                              "block": "minecraft:cobweb"
                            },
                            {
                              "char": "{",
                              "block": "minecraft:chain"
                            },
                            {
                              "char": "*",
                              "block": "minecraft:potted_cactus"
                            },
                            {
                              "char": "l",
                              "block": "minecraft:ladder[facing=north]"
                            },
                            {
                              "char": "-",
                              "block": "minecraft:oak_pressure_plate"
                            },
                            {
                              "char": ".",
                              "block": "minecraft:oak_fence"
                            },
                            {
                              "char": "L",
                              "block": "minecraft:bookshelf"
                            },
                            {
                              "char": "W",
                              "block": "minecraft:water"
                            },
                            {
                              "char": "C",
                              "block": "minecraft:chest[facing=north]",
                              "loot": "chestloot"
                            },
                            {
                              "char": "G",
                              "block": "minecraft:grass_block"
                            },
                            {
                              "char": "D",
                              "block": "minecraft:dirt"
                            },
                            {
                              "char": " ",
                              "block": "minecraft:air"
                            },
                            {
                              "char": "~",
                              "block": "minecraft:structure_void"
                            }
                          ]
                        }
                        """);
                Files.createDirectory(Path.of(directory + "/parts"));
                Files.writeString(Path.of(directory + "/parts/raildungeon1.json"), """
                        {
                          "xsize": 16,
                          "zsize": 16,
                          "refpalette": "rails",
                          "slices": [
                            [
                              "yyyyyyyyyyyyyyyy",
                              "yyyyyyyyyyyyyyyy",
                              "yyyyyyyyyyyyyyyy",
                              "yyyyyyyyyyyyyyyy",
                              "yyyyyyyyyyyyyyyy",
                              "yyyyyyyyyyyyyyyy",
                              "yyyyyyyyyyyyyyyy",
                              "yyyyyyyyyyyyyyyy",
                              "yyyyyyyyyyyyyyyy",
                              "yyyyyyyyyyyyyyyy",
                              "yyyyyyyyyyyyyyyy",
                              "yyyyyyyyyyyyyyyy",
                              "yyyyyyyyyyyyyyyy",
                              "yyyyyyyyyyyyyyyy",
                              "yyyyyyyyyyyyyyyy",
                              "yyyyyyyyyyyyyyyy"
                            ],
                            [
                              "yyyyyyyyyyyyyyyy",
                              "yyyyyyyyyyyyyyyy",
                              "y4yyyyyyyyyyyy1y",
                              "yyyyyyyyyyyyyyyy",
                              "yyyyyyyyyyyyyyyy",
                              "yyyyyyyyyyyyyyyy",
                              "yyyyyyyyyyyyyyyy",
                              "yyyyyyyyyyyyyyyy",
                              "y4yyyyyyyyyyyyyy",
                              "yyyyyyyyyyyyyyyy",
                              "yyyyyyyyyyyyyyyy",
                              "yyyyyyyyyyyyyyyy",
                              "yyyyyyyyyyyyyyyy",
                              "y1yyyyyyyyyyyy1y",
                              "yyyyyyyyyyyyyyyy",
                              "yyyyyyyyyyyyyyyy"
                            ],
                            [
                              "yyyyyy~~yyyyyyyy",
                              "yyy~~~~~~~~~~yyy",
                              "yyy~~~~~~~~~~yyy",
                              "yyy~~~~~~~~~~yyy",
                              "yyyC~~~~~yyyyyyy",
                              "yyy~~~~~~~~~~yyy",
                              "yyyC~~~~~~!!!yyy",
                              "yyy~~~~~~~!!4yyy",
                              "yyyC~~~~~~!!!yyy",
                              "yyy~~~~~~~~~~yyy",
                              "yyyC~~~~~yyyyyyy",
                              "yyy~~~~~~~~~~yyy",
                              "yyy~~~~~~~~~~yyy",
                              "yyy~~~~~~~~~~yyy",
                              "yyy~~~~~~~~~~yyy",
                              "yyyyyy~~yyyyyyyy"
                            ],
                            [
                              "yyyyyy~~yyyyyyyy",
                              "yyy~~~~~~~~~~yyy",
                              "yyy~~~~~~~~~~yyy",
                              "yyy~~~~~~~~~~yyy",
                              "yyy~~~~~~yyyyyyy",
                              "yyy~~~~~~~~~~yyy",
                              "yyy~~~~~~~!!!yyy",
                              "yyy~~~~~~~!!!yyy",
                              "yyy~~~~~~~!!!yyy",
                              "yyy~~~~~~~~~~yyy",
                              "yyy~~~~~~yyyyyyy",
                              "yyy~~~~~~~~~~yyy",
                              "yyy~~~~~~~~~~yyy",
                              "yyy~~~~~~~~~~yyy",
                              "yyy~~~~~~~~~~yyy",
                              "yyyyyy~~yyyyyyyy"
                            ],
                            [
                              "yyyyyyyyyyyyyyyy",
                              "yyy~~~~~~~~~~yyy",
                              "yyy~~~~~~~~~~yyy",
                              "yyy~~~~~~~~~~yyy",
                              "yyy~~~~~~yyyyyyy",
                              "yyy~~~~~~~~~~yyy",
                              "yyy~~~~~~~~~~yyy",
                              "yyy~~~~~~~~~~yyy",
                              "yyy~~~~~~~~~~yyy",
                              "yyy~~~~~~~~~~yyy",
                              "yyy~~~~~~yyyyyyy",
                              "yyy~~~~~~~~~~yyy",
                              "yyy~~~~~~~~~~yyy",
                              "yyy~~~~~~~~~~yyy",
                              "yyy~~~~~~~~~~yyy",
                              "yyyyyyyyyyyyyyyy"
                            ],
                            [
                              "yyyyyyyyyyyyyyyy",
                              "yyyyyyyyyyyyyyyy",
                              "yyyyyyyyyyyyyyyy",
                              "yyyyyyyyyyyyyyyy",
                              "yyyyyyyyyyyyyyyy",
                              "yyyyyyyyyyyyyyyy",
                              "yyyyyyyyyyyyyyyy",
                              "yyyyyyyyyyyyyyyy",
                              "yyyyyyyyyyyyyyyy",
                              "yyyyyyyyyyyyyyyy",
                              "yyyyyyyyyyyyyyyy",
                              "yyyyyyyyyyyyyyyy",
                              "yyyyyyyyyyyyyyyy",
                              "yyyyyyyyyyyyyyyy",
                              "yyyyyyyyyyyyyyyy",
                              "yyyyyyyyyyyyyyyy"
                            ]
                          ]
                        }""");
                Files.writeString(Path.of(directory + "/parts/cabin.json"), """
                        {
                          "xsize": 16,
                          "zsize": 16,
                          "palette": {
                            "palette": [
                              {
                                "char": "D",
                                "block": "minecraft:iron_door[half=lower]"
                              },
                              {
                                "char": "d",
                                "block": "minecraft:iron_door[half=upper]"
                              },
                              {
                                "char": "P",
                                "block": "minecraft:quartz_block"
                              },
                              {
                                "char": "B",
                                "block": "minecraft:barrel[facing=north]"
                              },
                              {
                                "char": "c",
                                "block": "minecraft:exposed_copper"
                              },
                              {
                                "char": "1",
                                "block": "minecraft:exposed_cut_copper_stairs[facing=north]"
                              },
                              {
                                "char": "2",
                                "block": "minecraft:exposed_cut_copper_stairs[facing=west]"
                              },
                              {
                                "char": "3",
                                "block": "minecraft:exposed_cut_copper_stairs[facing=south]"
                              },
                              {
                                "char": "4",
                                "block": "minecraft:exposed_cut_copper_stairs[facing=east]"
                              }
                            ]
                          },
                          "slices": [
                            [
                              "                ",
                              "                ",
                              "                ",
                              "   ############ ",
                              "   ############ ",
                              "   ############ ",
                              "   ##########   ",
                              "   ##########   ",
                              "   ##########   ",
                              "   ##########   ",
                              "   ##########   ",
                              "   ##########   ",
                              "   ##########   ",
                              "                ",
                              "                ",
                              "                "
                            ],
                            [
                              "                ",
                              "                ",
                              "                ",
                              "   ############ ",
                              "   ############ ",
                              "   ############ ",
                              "   ##########   ",
                              "   ##########   ",
                              "   ##########   ",
                              "   ##########   ",
                              "   ##########   ",
                              "   ##########   ",
                              "   ##########   ",
                              "                ",
                              "                ",
                              "                "
                            ],
                            [
                              "                ",
                              "                ",
                              "                ",
                              "   ############ ",
                              "   ############ ",
                              "   ############ ",
                              "   ##########   ",
                              "   ##########   ",
                              "   ##########   ",
                              "   ##########   ",
                              "   ##########   ",
                              "   ##########   ",
                              "   ##########   ",
                              "                ",
                              "                ",
                              "                "
                            ],
                            [
                              "                ",
                              "                ",
                              "                ",
                              "   cPPPPPPPPc   ",
                              "   P    B   P:  ",
                              "   P        P   ",
                              "   P        P   ",
                              "   PC       P   ",
                              "   P        P   ",
                              "   P        P   ",
                              "   P        P   ",
                              "   P        P   ",
                              "   cPDPPPPPPc   ",
                              "                ",
                              "                ",
                              "                "
                            ],
                            [
                              "                ",
                              "                ",
                              "                ",
                              "   cPPPPPPPPc   ",
                              "   P        P:  ",
                              "   P        P   ",
                              "   P        P   ",
                              "   P        P   ",
                              "   P        :   ",
                              "   P        :   ",
                              "   P        P   ",
                              "   P        P   ",
                              "   cPdPPP:PPc   ",
                              "                ",
                              "                ",
                              "                "
                            ],
                            [
                              "                ",
                              "                ",
                              "                ",
                              "   cPPPPPPPPc   ",
                              "   P        P:  ",
                              "   P        P   ",
                              "   P        P   ",
                              "   P        P   ",
                              "   P        P   ",
                              "   P        P   ",
                              "   P        P   ",
                              "   P        P   ",
                              "   cPPPPPPPPc   ",
                              "                ",
                              "                ",
                              "                "
                            ],
                            [
                              "                ",
                              "                ",
                              "                ",
                              "   c11111111c   ",
                              "   2########cc  ",
                              "   2########4   ",
                              "   2########4   ",
                              "   2########4   ",
                              "   2########4   ",
                              "   2########4   ",
                              "   2########4   ",
                              "   2########4   ",
                              "   c33333333c   ",
                              "                ",
                              "                ",
                              "                "
                            ],
                            [
                              "                ",
                              "                ",
                              "                ",
                              "                ",
                              "                ",
                              "     :    :     ",
                              "                ",
                              "                ",
                              "                ",
                              "                ",
                              "     :    :     ",
                              "                ",
                              "                ",
                              "                ",
                              "                ",
                              "                "
                            ]
                          ]
                        }""");
                Files.writeString(Path.of(directory + "/parts/fountain_example.json"), """
                        {
                          "xsize": 16,
                          "zsize": 16,
                          "slices": [
                            [
                              "                ",
                              "                ",
                              "                ",
                              "                ",
                              "                ",
                              "                ",
                              "      ####      ",
                              "      #WW#      ",
                              "      #WW#      ",
                              "      ####      ",
                              "                ",
                              "                ",
                              "                ",
                              "                ",
                              "                ",
                              "                "
                            ],
                            [
                              "                ",
                              "                ",
                              "                ",
                              "                ",
                              "                ",
                              "                ",
                              "      T  T      ",
                              "                ",
                              "                ",
                              "      T  T      ",
                              "                ",
                              "                ",
                              "                ",
                              "                ",
                              "                ",
                              "                "
                            ]
                          ]
                        }""");
                Files.writeString(Path.of(directory + "/parts/park_example.json"), """
                        {
                          "xsize": 16,
                          "zsize": 16,
                          "palette": {
                            "palette": [
                              {
                                "char": "P",
                                "blocks": [
                                  {
                                    "random": 32,
                                    "block": "minecraft:oak_sapling[stage=1]"
                                  },
                                  {
                                    "random": 32,
                                    "block": "minecraft:spruce_sapling[stage=1]"
                                  },
                                  {
                                    "random": 32,
                                    "block": "minecraft:birch_sapling[stage=1]"
                                  },
                                  {
                                    "random": 1000,
                                    "block": "minecraft:acacia_sapling[stage=1]"
                                  }
                                ]
                              }
                            ]
                          },
                          "slices": [
                            [
                              "                ",
                              "                ",
                              "  _____  _____  ",
                              "  _SSS_  _SSS_  ",
                              "  _SDS_  _SDS_  ",
                              "  _SSS_  _SSS_  ",
                              "  _____  _____  ",
                              "                ",
                              "                ",
                              "  _____  _____  ",
                              "  _SSS_  _SSS_  ",
                              "  _SDS_  _SDS_  ",
                              "  _SSS_  _SSS_  ",
                              "  _____  _____  ",
                              "                ",
                              "                "
                            ],
                            [
                              "                ",
                              "                ",
                              "                ",
                              "                ",
                              "   TP      PT   ",
                              "                ",
                              "                ",
                              "                ",
                              "                ",
                              "                ",
                              "                ",
                              "   TP      PT   ",
                              "                ",
                              "                ",
                              "                ",
                              "                "
                            ]
                          ]
                        }""");
                Files.writeString(Path.of(directory + "/parts/stairs1.json"), """
                        {
                          "meta": [
                            {
                              "integer": 0,
                              "key": "z1"
                            },
                            {
                              "integer": 2,
                              "key": "z2"
                            }
                          ],
                          "xsize": 2,
                          "zsize": 13,
                          "slices": [
                            [
                              "  ",
                              "  ",
                              " w",
                              " T",
                              "  ",
                              "  ",
                              "  ",
                              "  ",
                              "  ",
                              "  ",
                              "  ",
                              "==",
                              "__"
                            ],
                            [
                              "  ",
                              "  ",
                              " w",
                              "  ",
                              "  ",
                              "  ",
                              "  ",
                              "  ",
                              "  ",
                              "==",
                              "__",
                              "  ",
                              "  "
                            ],
                            [
                              "  ",
                              "  ",
                              " w",
                              "  ",
                              "  ",
                              "  ",
                              "  ",
                              "==",
                              "__",
                              "  ",
                              "  ",
                              "  ",
                              "  "
                            ],
                            [
                              "  ",
                              "  ",
                              " w",
                              "  ",
                              "  ",
                              "==",
                              "__",
                              "  ",
                              "  ",
                              "  ",
                              "  ",
                              "  ",
                              "  "
                            ],
                            [
                              "  ",
                              "  ",
                              " w",
                              "==",
                              "__",
                              "  ",
                              "  ",
                              "  ",
                              "  ",
                              "  ",
                              "  ",
                              "  ",
                              "  "
                            ],
                            [
                              "__",
                              "__",
                              "__",
                              "  ",
                              "  ",
                              "  ",
                              "  ",
                              "  ",
                              "  ",
                              "  ",
                              "  ",
                              "  ",
                              "  "
                            ]
                          ]
                        }""");
                Files.writeString(Path.of(directory + "/parts/stairs2.json"), """
                        {
                          "meta": [
                            {
                              "integer": 13,
                              "key": "z1"
                            },
                            {
                              "integer": 15,
                              "key": "z2"
                            }
                          ],
                          "xsize": 2,
                          "zsize": 16,
                          "slices": [
                            [
                              "  ",
                              "  ",
                              "  ",
                              "__",
                              "==",
                              "  ",
                              "  ",
                              "  ",
                              "  ",
                              "  ",
                              "  ",
                              "  ",
                              " T",
                              " w",
                              "  ",
                              "  "
                            ],
                            [
                              "  ",
                              "  ",
                              "  ",
                              "  ",
                              "  ",
                              "__",
                              "==",
                              "  ",
                              "  ",
                              "  ",
                              "  ",
                              "  ",
                              "  ",
                              " w",
                              "  ",
                              "  "
                            ],
                            [
                              "  ",
                              "  ",
                              "  ",
                              "  ",
                              "  ",
                              "  ",
                              "  ",
                              "__",
                              "==",
                              "  ",
                              "  ",
                              "  ",
                              "  ",
                              " w",
                              "  ",
                              "  "
                            ],
                            [
                              "  ",
                              "  ",
                              "  ",
                              "  ",
                              "  ",
                              "  ",
                              "  ",
                              "  ",
                              "  ",
                              "__",
                              "==",
                              "  ",
                              "  ",
                              " w",
                              "  ",
                              "  "
                            ],
                            [
                              "  ",
                              "  ",
                              "  ",
                              "  ",
                              "  ",
                              "  ",
                              "  ",
                              "  ",
                              "  ",
                              "  ",
                              "  ",
                              "__",
                              "==",
                              " w",
                              "  ",
                              "  "
                            ],
                            [
                              "  ",
                              "  ",
                              "  ",
                              "  ",
                              "  ",
                              "  ",
                              "  ",
                              "  ",
                              "  ",
                              "  ",
                              "  ",
                              "  ",
                              "  ",
                              "__",
                              "__",
                              "__"
                            ]
                          ]
                        }""");
                Files.writeString(Path.of(directory + "/parts/stairsbig.json"), """
                        {
                          "meta": [
                            {
                              "integer": 4,
                              "key": "z1"
                            },
                            {
                              "integer": 11,
                              "key": "z2"
                            }
                          ],
                          "xsize": 6,
                          "zsize": 12,
                          "slices": [
                            [
                              "      ",
                              "      ",
                              "      ",
                              "      ",
                              "xxxxxx",
                              "xxxxx/",
                              "xxxxx/",
                              "xxxxx/",
                              "xxxxx/",
                              "xxxxx/",
                              "xxxxx/",
                              "xxxxxx"
                            ],
                            [
                              "      ",
                              "      ",
                              "      ",
                              "      ",
                              "xxxxx_",
                              "xxxx/ ",
                              "xxxx/ ",
                              "xxxx/ ",
                              "xxxx/ ",
                              "xxxx/ ",
                              "xxxx/ ",
                              "xxxxx_"
                            ],
                            [
                              "      ",
                              "      ",
                              "      ",
                              "      ",
                              "xxxx_ ",
                              "xxx/  ",
                              "xxx/  ",
                              "xxx/  ",
                              "xxx/  ",
                              "xxx/  ",
                              "xxx/  ",
                              "xxxx_ "
                            ],
                            [
                              "      ",
                              "      ",
                              "      ",
                              "      ",
                              "xxx_  ",
                              "xx/   ",
                              "xx/   ",
                              "xx/   ",
                              "xx/   ",
                              "xx/   ",
                              "xx/   ",
                              "xxx_  "
                            ],
                            [
                              "      ",
                              "      ",
                              "      ",
                              "      ",
                              "xx_   ",
                              "x/    ",
                              "x/    ",
                              "x/    ",
                              "x/    ",
                              "x/    ",
                              "x/    ",
                              "xx_   "
                            ],
                            [
                              "      ",
                              "      ",
                              "      ",
                              "      ",
                              "x_    ",
                              "/     ",
                              "/     ",
                              "/     ",
                              "/     ",
                              "/     ",
                              "/     ",
                              "x_    "
                            ],
                            [
                              "      ",
                              "      ",
                              "      ",
                              "      ",
                              "_     ",
                              "      ",
                              "      ",
                              "      ",
                              "      ",
                              "      ",
                              "      ",
                              "_     "
                            ]
                          ]
                        }""");
                Files.writeString(Path.of(directory + "/parts/stairsnormal.json"), """
                        {
                          "meta": [
                            {
                              "integer": 5,
                              "key": "z1"
                            },
                            {
                              "integer": 10,
                              "key": "z2"
                            }
                          ],
                          "xsize": 6,
                          "zsize": 11,
                          "slices": [
                            [
                              "      ",
                              "      ",
                              "      ",
                              "      ",
                              "      ",
                              "xxxxxx",
                              "xxxxx/",
                              "xxxxx/",
                              "xxxxx/",
                              "xxxxx/",
                              "xxxxxx"
                            ],
                            [
                              "      ",
                              "      ",
                              "      ",
                              "      ",
                              "      ",
                              "xxxxx_",
                              "xxxx/ ",
                              "xxxx/ ",
                              "xxxx/ ",
                              "xxxx/ ",
                              "xxxxx_"
                            ],
                            [
                              "      ",
                              "      ",
                              "      ",
                              "      ",
                              "      ",
                              "xxxx_ ",
                              "xxx/  ",
                              "xxx/  ",
                              "xxx/  ",
                              "xxx/  ",
                              "xxxx_ "
                            ],
                            [
                              "      ",
                              "      ",
                              "      ",
                              "      ",
                              "      ",
                              "xxx_  ",
                              "xx/   ",
                              "xx/   ",
                              "xx/   ",
                              "xx/   ",
                              "xxx_  "
                            ],
                            [
                              "      ",
                              "      ",
                              "      ",
                              "      ",
                              "      ",
                              "xx_   ",
                              "x/    ",
                              "x/    ",
                              "x/    ",
                              "x/    ",
                              "xx_   "
                            ],
                            [
                              "      ",
                              "      ",
                              "      ",
                              "      ",
                              "      ",
                              "x_    ",
                              "/     ",
                              "/     ",
                              "/     ",
                              "/     ",
                              "x_    "
                            ],
                            [
                              "      ",
                              "      ",
                              "      ",
                              "      ",
                              "      ",
                              "_     ",
                              "      ",
                              "      ",
                              "      ",
                              "      ",
                              "_     "
                            ]
                          ]
                        }""");
                Files.writeString(Path.of(directory + "/parts/building_front_example.json"), """
                        {
                          "xsize": 2,
                          "zsize": 16,
                          "slices": [
                            [
                              "  ",
                              "  ",
                              "  ",
                              " w",
                              "  ",
                              "  ",
                              "  ",
                              "  ",
                              "  ",
                              "  ",
                              "  ",
                              "  ",
                              " w",
                              "  ",
                              "  ",
                              "  "
                            ],
                            [
                              "  ",
                              "  ",
                              "  ",
                              " w",
                              "  ",
                              "  ",
                              "  ",
                              "  ",
                              "  ",
                              "  ",
                              "  ",
                              "  ",
                              " w",
                              "  ",
                              "  ",
                              "  "
                            ],
                            [
                              "  ",
                              "  ",
                              "  ",
                              " w",
                              "  ",
                              "  ",
                              "  ",
                              "  ",
                              "  ",
                              "  ",
                              "  ",
                              "  ",
                              " w",
                              "  ",
                              "  ",
                              "  "
                            ],
                            [
                              "  ",
                              "  ",
                              "  ",
                              "__",
                              "__",
                              "__",
                              "__",
                              "__",
                              "__",
                              "__",
                              "__",
                              "__",
                              "__",
                              "  ",
                              "  ",
                              "  "
                            ]
                          ]
                        }""");
                Files.writeString(Path.of(directory + "/parts/bridge_open.json"), """
                        {
                          "meta": [
                            {
                              "key": "support",
                              "char": "v"
                            }
                          ],
                          "xsize": 16,
                          "zsize": 16,
                          "slices": [
                            [
                              "                ",
                              "                ",
                              "                ",
                              "vvvvvvvvvvvvvvvv",
                              "SSSSSSSSSSSSSSSS",
                              "SSSSSSSSSSSSSSSS",
                              "SSSSSSSSSSSSSSSS",
                              "SSSSSSSSSSSSSSSS",
                              "SSSSSSSSSSSSSSSS",
                              "SSSSSSSSSSSSSSSS",
                              "SSSSSSSSSSSSSSSS",
                              "SSSSSSSSSSSSSSSS",
                              "vvvvvvvvvvvvvvvv",
                              "                ",
                              "                ",
                              "                "
                            ],
                            [
                              "                ",
                              "                ",
                              "                ",
                              "wwwwvwwwwwwwvwww",
                              "                ",
                              "                ",
                              "                ",
                              "                ",
                              "                ",
                              "                ",
                              "                ",
                              "                ",
                              "wwwwvwwwwwwwvwww",
                              "                ",
                              "                ",
                              "                "
                            ],
                            [
                              "                ",
                              "                ",
                              "                ",
                              "    w       w   ",
                              "                ",
                              "                ",
                              "                ",
                              "                ",
                              "                ",
                              "                ",
                              "                ",
                              "                ",
                              "    w       w   ",
                              "                ",
                              "                ",
                              "                "
                            ],
                            [
                              "                ",
                              "                ",
                              "                ",
                              "    w       w   ",
                              "                ",
                              "                ",
                              "                ",
                              "                ",
                              "                ",
                              "                ",
                              "                ",
                              "                ",
                              "    w       w   ",
                              "                ",
                              "                ",
                              "                "
                            ]
                          ]
                        }""");
                Files.writeString(Path.of(directory + "/parts/bridge_covered.json"), """
                        {
                          "meta": [
                            {
                              "key": "support",
                              "char": "v"
                            }
                          ],
                          "xsize": 16,
                          "zsize": 16,
                          "slices": [
                            [
                              "                ",
                              "                ",
                              "                ",
                              "vvvvvvvvvvvvvvvv",
                              "SSSSSSSSSSSSSSSS",
                              "SSSSSSSSSSSSSSSS",
                              "SSSSSSSSSSSSSSSS",
                              "SSSSSSSSSSSSSSSS",
                              "SSSSSSSSSSSSSSSS",
                              "SSSSSSSSSSSSSSSS",
                              "SSSSSSSSSSSSSSSS",
                              "SSSSSSSSSSSSSSSS",
                              "vvvvvvvvvvvvvvvv",
                              "                ",
                              "                ",
                              "                "
                            ],
                            [
                              "                ",
                              "                ",
                              "                ",
                              "wwwwvwwwwwwwvwww",
                              "    T       T   ",
                              "                ",
                              "                ",
                              "                ",
                              "                ",
                              "                ",
                              "                ",
                              "    T       T   ",
                              "wwwwvwwwwwwwvwww",
                              "                ",
                              "                ",
                              "                "
                            ],
                            [
                              "                ",
                              "                ",
                              "                ",
                              "    w       w   ",
                              "                ",
                              "                ",
                              "                ",
                              "                ",
                              "                ",
                              "                ",
                              "                ",
                              "                ",
                              "    w       w   ",
                              "                ",
                              "                ",
                              "                "
                            ],
                            [
                              "                ",
                              "                ",
                              "                ",
                              "    w       w   ",
                              "                ",
                              "                ",
                              "                ",
                              "                ",
                              "                ",
                              "                ",
                              "                ",
                              "                ",
                              "    w       w   ",
                              "                ",
                              "                ",
                              "                "
                            ],
                            [
                              "                ",
                              "                ",
                              "                ",
                              "    w       w   ",
                              "                ",
                              "                ",
                              "                ",
                              "                ",
                              "                ",
                              "                ",
                              "                ",
                              "                ",
                              "    w       w   ",
                              "                ",
                              "                ",
                              "                "
                            ],
                            [
                              "                ",
                              "                ",
                              "                ",
                              "    w       w   ",
                              "                ",
                              "                ",
                              "                ",
                              "                ",
                              "                ",
                              "                ",
                              "                ",
                              "                ",
                              "    w       w   ",
                              "                ",
                              "                ",
                              "                "
                            ],
                            [
                              "                ",
                              "                ",
                              "                ",
                              "vvvvvvvvvvvvvvvv",
                              "SSSSSSSSSSSSSSSS",
                              "SSSSSSSSSSSSSSSS",
                              "SSSSSSSSSSSSSSSS",
                              "SSSSSSSSSSSSSSSS",
                              "SSSSSSSSSSSSSSSS",
                              "SSSSSSSSSSSSSSSS",
                              "SSSSSSSSSSSSSSSS",
                              "SSSSSSSSSSSSSSSS",
                              "vvvvvvvvvvvvvvvv",
                              "                ",
                              "                ",
                              "                "
                            ]
                          ]
                        }""");
                Files.writeString(Path.of(directory + "/parts/building1_1.json"), """
                        {
                          "xsize": 16,
                          "zsize": 16,
                          "slices": [
                            [
                              "################",
                              "################",
                              "################",
                              "################",
                              "################",
                              "################",
                              "################",
                              "################",
                              "################",
                              "#######l########",
                              "##########1#####",
                              "################",
                              "################",
                              "################",
                              "################",
                              "################"
                            ],
                            [
                              "#aa@aaaaaaaa@aa#",
                              "a  #        #  a",
                              "a  #F       #  a",
                              "@  #F      L#  @",
                              "a  #D      L#  a",
                              "a  #        #  a",
                              "a              a",
                              "a  #        #  a",
                              "a  #        #  a",
                              "a  #   l    #  a",
                              "a  ##########  a",
                              "a              a",
                              "@              @",
                              "a              a",
                              "a     F        a",
                              "#aa@aaaaaaaa@aa#"
                            ],
                            [
                              "#aa@aaaaaaaa@aa#",
                              "a  #        #  a",
                              "a  #        #  a",
                              "@  #       L#  @",
                              "a  #*      L#  a",
                              "a  #        #  a",
                              "a              a",
                              "a  #        #  a",
                              "a  #        #  a",
                              "a  #   l    #  a",
                              "a  ##########  a",
                              "a       T      a",
                              "@              @",
                              "a              a",
                              "a              a",
                              "#aa@aaaaaaaa@aa#"
                            ],
                            [
                              "#aa@aaaaaaaa@aa#",
                              "a  #        #  a",
                              "a  #        #  a",
                              "@  #        #  @",
                              "a  #        #  a",
                              "a  #        #  a",
                              "a  #        #  a",
                              "a  #        #  a",
                              "a  #        #  a",
                              "a  #   l    #  a",
                              "a  ##########  a",
                              "a              a",
                              "@              @",
                              "a              a",
                              "a              a",
                              "#aa@aaaaaaaa@aa#"
                            ],
                            [
                              "################",
                              "################",
                              "################",
                              "################",
                              "################",
                              "################",
                              "################",
                              "################",
                              "################",
                              "#######l########",
                              "################",
                              "################",
                              "################",
                              "################",
                              "################",
                              "################"
                            ],
                            [
                              "################",
                              "################",
                              "################",
                              "################",
                              "################",
                              "################",
                              "################",
                              "################",
                              "################",
                              "#######l########",
                              "################",
                              "################",
                              "################",
                              "################",
                              "################",
                              "################"
                            ]
                          ]
                        }""");
                Files.writeString(Path.of(directory + "/parts/building1_2.json"), """
                        {
                          "xsize": 16,
                          "zsize": 16,
                          "slices": [
                            [
                              "################",
                              "################",
                              "################",
                              "################",
                              "################",
                              "################",
                              "################",
                              "################",
                              "################",
                              "#######l########",
                              "####1###########",
                              "################",
                              "################",
                              "################",
                              "################",
                              "################"
                            ],
                            [
                              "#aa@aaaaaaaa@aa#",
                              "a  F      QQQ  a",
                              "a              a",
                              "@              @",
                              "a              a",
                              "a             Fa",
                              "a              a",
                              "a              a",
                              "a              a",
                              "a      l       a",
                              "a###########  #a",
                              "a              a",
                              "@              @",
                              "a              a",
                              "a              a",
                              "#aa@aaaaaaaa@aa#"
                            ],
                            [
                              "#aa@aaaaaaaa@aa#",
                              "a         **   a",
                              "a              a",
                              "@              @",
                              "a              a",
                              "a              a",
                              "a              a",
                              "a              a",
                              "a              a",
                              "a    T l       a",
                              "a#::########  #a",
                              "a    T         a",
                              "@              @",
                              "a              a",
                              "a              a",
                              "#aa@aaaaaaaa@aa#"
                            ],
                            [
                              "#aa@aaaaaaaa@aa#",
                              "a              a",
                              "a              a",
                              "@              @",
                              "a              a",
                              "a              a",
                              "a              a",
                              "a              a",
                              "a              a",
                              "a      l       a",
                              "a##############a",
                              "a              a",
                              "@              @",
                              "a              a",
                              "a              a",
                              "#aa@aaaaaaaa@aa#"
                            ],
                            [
                              "################",
                              "################",
                              "################",
                              "################",
                              "################",
                              "################",
                              "################",
                              "################",
                              "################",
                              "#######l########",
                              "################",
                              "################",
                              "################",
                              "################",
                              "################",
                              "################"
                            ],
                            [
                              "################",
                              "################",
                              "################",
                              "################",
                              "################",
                              "################",
                              "################",
                              "################",
                              "################",
                              "#######l########",
                              "################",
                              "################",
                              "################",
                              "################",
                              "################",
                              "################"
                            ]
                          ]
                        }""");
                Files.writeString(Path.of(directory + "/parts/building1_3.json"), """
                        {
                          "xsize": 16,
                          "zsize": 16,
                          "slices": [
                            [
                              "################",
                              "################",
                              "################",
                              "################",
                              "################",
                              "################",
                              "################",
                              "################",
                              "################",
                              "#######l########",
                              "################",
                              "################",
                              "################",
                              "################",
                              "################",
                              "################"
                            ],
                            [
                              "#aa@aaaaaaaa@aa#",
                              "aWWWWWWWWWWWWWWa",
                              "aWWWWWWWWWWWWWWa",
                              "@WWWWWWWWWWWWWW@",
                              "aWWWWWWWWWWWWWWa",
                              "aaaaaaaaaaaaaaaa",
                              "a              a",
                              "a              a",
                              "aL             a",
                              "aF     l       a",
                              "aF    ###::::::a",
                              "a      :       a",
                              "@      :   T   @",
                              "a      :       a",
                              "a      :       a",
                              "#aa@aaaaaaaa@aa#"
                            ],
                            [
                              "#aa@aaaaaaaa@aa#",
                              "aWWWWWWWWWWWWWWa",
                              "aWWWWWWWWWWWWWWa",
                              "@WWWWWWWWWWWWWW@",
                              "aWWWWWWWWWWWWWWa",
                              "aaaaaaaaaaaaaaaa",
                              "a              a",
                              "a              a",
                              "aL             a",
                              "a      l       a",
                              "a     ###::::::a",
                              "a      :       a",
                              "@      :       @",
                              "a      :       a",
                              "a      :       a",
                              "#aa@aaaaaaaa@aa#"
                            ],
                            [
                              "#aa@aaaaaaaa@aa#",
                              "aWWWWWWWWWWWWWWa",
                              "aWWWWWWWWWWWWWWa",
                              "@WWWWWWWWWWWWWW@",
                              "aWWWWWWWWWWWWWWa",
                              "aaaaaaaaaaaaaaaa",
                              "a              a",
                              "a              a",
                              "aL             a",
                              "a      l       a",
                              "a     ###::::::a",
                              "a      :       a",
                              "@      :       @",
                              "a      :       a",
                              "a      :       a",
                              "#aa@aaaaaaaa@aa#"
                            ],
                            [
                              "################",
                              "################",
                              "################",
                              "################",
                              "################",
                              "################",
                              "################",
                              "################",
                              "################",
                              "#######l########",
                              "################",
                              "################",
                              "##1#1###########",
                              "################",
                              "################",
                              "################"
                            ],
                            [
                              "################",
                              "################",
                              "################",
                              "################",
                              "################",
                              "################",
                              "################",
                              "################",
                              "################",
                              "#######l########",
                              "################",
                              "################",
                              "################",
                              "################",
                              "################",
                              "################"
                            ]
                          ]
                        }""");
                Files.writeString(Path.of(directory + "/parts/top1x1_1.json"), """
                        {
                          "xsize": 16,
                          "zsize": 16,
                          "slices": [
                            [
                              "                ",
                              "                ",
                              "            :   ",
                              "                ",
                              "                ",
                              "                ",
                              "                ",
                              "     :   :      ",
                              "                ",
                              "                ",
                              "                ",
                              "     :   :      ",
                              "                ",
                              "                ",
                              "                ",
                              "                "
                            ],
                            [
                              "                ",
                              "                ",
                              "            :   ",
                              "                ",
                              "                ",
                              "                ",
                              "                ",
                              "     :   :      ",
                              "                ",
                              "                ",
                              "                ",
                              "     :   :      ",
                              "                ",
                              "                ",
                              "                ",
                              "                "
                            ],
                            [
                              "                ",
                              "                ",
                              "            :   ",
                              "                ",
                              "                ",
                              "                ",
                              "                ",
                              "     #####      ",
                              "     #####      ",
                              "     #####      ",
                              "     #####      ",
                              "     #####      ",
                              "                ",
                              "                ",
                              "                ",
                              "                "
                            ],
                            [
                              "                ",
                              "                ",
                              "            :   ",
                              "                ",
                              "                ",
                              "                ",
                              "                ",
                              "                ",
                              "                ",
                              "                ",
                              "                ",
                              "                ",
                              "                ",
                              "                ",
                              "                ",
                              "                "
                            ],
                            [
                              "                ",
                              "                ",
                              "            :   ",
                              "                ",
                              "                ",
                              "                ",
                              "                ",
                              "                ",
                              "                ",
                              "                ",
                              "                ",
                              "                ",
                              "                ",
                              "                ",
                              "                ",
                              "                "
                            ],
                            [
                              "                ",
                              "                ",
                              "                ",
                              "                ",
                              "                ",
                              "                ",
                              "                ",
                              "                ",
                              "                ",
                              "                ",
                              "                ",
                              "                ",
                              "                ",
                              "                ",
                              "                ",
                              "                "
                            ]
                          ]
                        }""");
                Files.createDirectory(Path.of(directory + "/scattered"));
                Files.writeString(Path.of(directory + "/scattered/cabin.json"), """
                        {
                          "buildings": [ "cabin" ],
                          "terrainheight": "highest",
                          "terrainfix": "none",
                          "heightoffset": -3
                        }""");
                Files.createDirectory(Path.of(directory + "/stuff"));
                Files.writeString(Path.of(directory + "/stuff/cobweb.json"), """
                        {
                          "tags": ["rubble"],
                          "column": "\\\\",
                          "mincount": 5,
                          "maxcount": 20,
                          "attempts": 8,
                          "inbuilding": true,
                          "upperblocks": {
                            "excluding": [
                              "minecraft:air"
                            ]
                          }
                        }""");
                Files.createDirectory(Path.of(directory + "/styles"));
                Files.writeString(Path.of(directory + "/styles/desert.json"), """
                        {
                          "randompalettes": [
                            [
                              {
                                "factor": 1.0,
                                "palette": "common"
                              }
                            ],
                            [
                              {
                                "factor": 1.0,
                                "palette": "default_desert"
                              }
                            ]
                          ]
                        }
                        """);
                Files.writeString(Path.of(directory + "/styles/standard.json"), """
                        {
                          "randompalettes": [
                            [
                              {
                                "factor": 1.0,
                                "palette": "common"
                              }
                            ],
                            [
                              {
                                "factor": 1.0,
                                "palette": "default"
                              }
                            ],
                        \t[
                              {
                                "factor": 1.0,
                                "palette": "bricks_standard"
                              }
                            ],
                          [
                              {
                                "factor": 1.0,
                                "palette": "glass_full"
                              }
                            ],
                            [
                              {
                                "factor": 1.0,
                                "palette": "glass_side_variant_bricks"
                              }
                            ]
                          ]
                        }
                        """);
                Files.createDirectory(Path.of(directory + "/worldstyles"));
                Files.writeString(Path.of(directory + "/worldstyles/standard.json"), """
                        {
                            "outsidestyle": "outside",
                            "multisettings": {
                                "areasize": 10,
                                "minimum": 1,
                                "maximum": 5,
                                "correctstylefactor": 0.8,
                                "attempts": 50
                            },
                            "scattered": {
                                "areasize": 8,
                                "chance": 0.1,
                                "weightnone": 20,
                                "list": [
                                    {
                                        "name": "cabin",
                                        "weight": 10,
                                        "maxheightdiff": 2,
                                        "biomes": {
                                            "excluding": [
                                                "#minecraft:is_ocean",
                                                "#minecraft:is_river",
                                                "#minecraft:is_beach"
                                            ]
                                        }
                                    }
                                ]
                            },
                            "citybiomemultipliers": [
                                {
                                    "multiplier": 0.1,
                                    "biomes": {
                                        "if_any": [
                                            "#minecraft:is_ocean"
                                        ]
                                    }
                                },
                                {
                                    "multiplier": 0.3,
                                    "biomes": {
                                        "if_any": [
                                            "#minecraft:is_river"
                                        ]
                                    }
                                }
                            ],
                            "citystyles": [
                                {
                                    "factor": 1,
                                    "citystyle": "citystyle_standard"
                                }
                            ]
                        }""");


            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

    }
}
